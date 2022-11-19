package com.gb.tech.financialassistant.service;

import com.gb.tech.financialassistant.dto.FinancialOperationDto;


import java.util.List;

public interface FinancialOperationService {

    FinancialOperationDto getById(Long id);

    List<FinancialOperationDto> getAll(Boolean isSpending);

    void save(FinancialOperationDto financialOperationDto);

    void delete(Long id);
}
