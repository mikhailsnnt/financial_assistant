package com.gb.tech.apioperation.service;

import com.gb.tech.apioperation.dto.FinancialOperationDto;

import java.util.List;

public interface FinancialOperationService {

    FinancialOperationDto getById(Long id);

    List<FinancialOperationDto> getAll(Boolean isSpending);

    void save(FinancialOperationDto financialOperationDto);

    void delete(Long id);
}
