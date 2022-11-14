package com.gb.tech.financialassistant.service;

import com.gb.tech.financialassistant.domain.FinancialOperation;
import com.gb.tech.financialassistant.dto.FinancialOperationDto;


import javax.transaction.Transactional;
import java.util.List;

public interface FinancialOperationService {

    FinancialOperationDto getFinancialOperationById(Long id);

    List<FinancialOperationDto> getAllFinancialOperation();

    List<FinancialOperationDto> getAllFinancialOperationIsSpending(Boolean isSpending);

    @Transactional
    void saveFinancialOperation(FinancialOperationDto financialOperationDto);

    void deleteFinancialOperation(Long id);
}
