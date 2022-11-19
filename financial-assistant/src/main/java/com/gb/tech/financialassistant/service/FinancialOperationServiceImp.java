package com.gb.tech.financialassistant.service;

import com.gb.tech.financialassistant.exeptions.InvalidParamsException;
import com.gb.tech.financialassistant.repository.FinancialOperationRepository;
import com.gb.tech.financialassistant.entity.FinancialOperation;
import com.gb.tech.financialassistant.dto.FinancialOperationDto;
import com.gb.tech.financialassistant.mapper.FinancialOperationMapper;
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
        FinancialOperation financialOperation = financialOperationRepository.findById(id).orElse(null);
        // с обработкой ошибок определимся позже.
        if (financialOperation == null) {
            throw new InvalidParamsException("financialOperation:" + null);
        }
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
