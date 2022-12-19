package com.gb.tech.apioperation.service;

import com.gb.financial.assistant.lib.exception.security.InvalidParamsException;
import com.gb.tech.apioperation.repository.FinancialOperationRepository;
import com.gb.tech.apioperation.entity.FinancialOperation;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;


@Service
@AllArgsConstructor
public class FinancialOperationServiceImp implements FinancialOperationService{

    private final FinancialOperationRepository financialOperationRepository;

    @Override
    public FinancialOperation getById(Long id){
        FinancialOperation financialOperation = financialOperationRepository.findById(id).orElseThrow(()
                -> new InvalidParamsException("financialOperation not found"));
        return financialOperation;
    }

    @Override
    public List<FinancialOperation> getAll(Boolean isSpending, Long accountId){
        return financialOperationRepository.findAllByIsSpendingAndAccountId(isSpending, accountId);
    }

    @Override
    @Transactional
    public void save(FinancialOperation financialOperation) {
        financialOperationRepository.save(financialOperation);
    }

    @Override
    public void delete(Long id){
        financialOperationRepository.deleteById(id);
    }
}
