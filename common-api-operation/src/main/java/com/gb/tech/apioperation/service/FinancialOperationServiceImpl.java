package com.gb.tech.apioperation.service;

import com.gb.financial.assistant.lib.data.account.AccountDto;
import com.gb.financial.assistant.lib.data.operation.OperationDto;
import com.gb.financial.assistant.lib.data.operation.OperationSaveDto;
import com.gb.financial.assistant.lib.exception.security.BadRequestException;
import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.repository.FinancialOperationRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@AllArgsConstructor
public class FinancialOperationServiceImpl implements FinancialOperationService {

    private final FinancialOperationRepository repository;
    private final AccountGateway accountGateway;

    @Override
    public OperationDto getById(long id) {
        return mapToDto(retrieveById(id));
    }

    @Override
    public List<OperationDto> getAll(boolean isSpending) {
        List<Long> accountIds = accountGateway
                .getAll()
                .stream()
                .map(AccountDto::getId).toList();
        return repository
                .findAllByIsSpendingAndAccountIdIn(isSpending, accountIds)
                .stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public long save(OperationSaveDto dto) {
        return repository.save(mapToEntity(dto)).getId();
    }

    @Override
    public void delete(long id) {
        repository.delete(retrieveById(id));
    }

    private FinancialOperation retrieveById(long id) {
        return repository
                .findById(id)
                .map(
                        it -> {
                            //Ensure user has access to account
                            accountGateway.getById(id);
                            return it;
                        }
                )
                .orElseThrow(()
                        -> new BadRequestException(String.format("Operation with id %s not found", id)));
    }

    private OperationDto mapToDto(FinancialOperation entity) {
        return new OperationDto(
                entity.getId(),
                entity.getAccountId(),
                entity.getOperationCategoryId(),
                entity.getIsSpending(),
                entity.getAmount(),
                entity.getDateTime());
    }

    private FinancialOperation mapToEntity(OperationSaveDto dto) {
        return new FinancialOperation(
                null,
                dto.getAccountId(),
                dto.getOperationCategoryId(),
                dto.isSpending(),
                dto.getAmount(),
                dto.getDateTime()
        );
    }
}
