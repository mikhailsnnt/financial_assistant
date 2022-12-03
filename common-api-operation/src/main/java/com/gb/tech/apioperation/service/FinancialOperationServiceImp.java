package com.gb.tech.apioperation.service;


import com.gb.financial.assistant.lib.exception.security.BadCredentialsException;
import com.gb.financial.assistant.lib.exception.security.InvalidParamsException;
import com.gb.tech.apioperation.repository.FinancialOperationRepository;
import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.mapper.FinancialOperationMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
public class FinancialOperationServiceImp implements FinancialOperationService{

    private final FinancialOperationMapper mapper = FinancialOperationMapper.MAPPER;

    private final FinancialOperationRepository financialOperationRepository;

    @Override
    public FinancialOperationDto getById(Long id){
        FinancialOperation financialOperation = financialOperationRepository.findById(id).orElseThrow(()
                -> new InvalidParamsException("financialOperation not found"));
        return mapper.fromFinancialOperation(financialOperation);
    }

    @Override
    public List<FinancialOperationDto> getAll(Boolean isSpending){
        return mapper.fromFinancialOperationList(financialOperationRepository.findAllByIsSpending(isSpending));
    }

    @Override
    @Transactional
    public void save(FinancialOperationDto financialOperationDto) {
        financialOperationRepository.save(mapper.toFinancialOperation(financialOperationDto));

    }

    @Override
    public void delete(Long id){
        financialOperationRepository.deleteById(id);
    }
}
