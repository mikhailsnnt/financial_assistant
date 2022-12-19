package com.gb.tech.apioperation.service;

import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.entity.FinancialOperation;

import java.util.List;

public interface FinancialOperationService {

    FinancialOperation getById(Long id);

    List<FinancialOperation> getAll(Boolean isSpending, Long accountId);

    void save(FinancialOperation financialOperation);

    void delete(Long id);
}
