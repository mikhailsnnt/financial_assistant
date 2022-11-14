package com.gb.tech.financialassistant.service;

import com.gb.tech.financialassistant.dao.FinancialOperationRepository;
import com.gb.tech.financialassistant.domain.FinancialOperation;
import com.gb.tech.financialassistant.dto.FinancialOperationDto;
import com.gb.tech.financialassistant.mapper.FinancialOperationMapper;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;

@Service
public class FinancialOperationServiceImp implements FinancialOperationService{

    private final FinancialOperationMapper mapper = FinancialOperationMapper.MAPPER;

    private final FinancialOperationRepository financialOperationRepository;


    public FinancialOperationServiceImp(FinancialOperationRepository financialOperationRepository) {
        this.financialOperationRepository = financialOperationRepository;
    }

    @Override
    public FinancialOperationDto getFinancialOperationById(Long id){
        FinancialOperation financialOperation = financialOperationRepository.findById(id).orElse(null);
        return FinancialOperationMapper.MAPPER.fromFinancialOperation(financialOperation);
    }

    @Override
    public List<FinancialOperationDto> getAllFinancialOperation() {
        return FinancialOperationMapper.MAPPER.fromFinancialOperationList(financialOperationRepository.findAll());
    }

    @Override
    public List<FinancialOperationDto> getAllFinancialOperationIsSpending(Boolean isSpending){
        return FinancialOperationMapper.MAPPER
                .fromFinancialOperationList(financialOperationRepository.findAllByIsSpending(isSpending));
    }

    @Override
    @Transactional
    public void saveFinancialOperation(FinancialOperationDto financialOperationDto) {

        financialOperationRepository.save(mapper.toFinancialOperation(financialOperationDto));

    }

    @Override
    public void deleteFinancialOperation(Long id){

        financialOperationRepository.deleteById(id);
    }


}
