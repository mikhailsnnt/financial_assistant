package com.gb.tech.apioperation.service;


import com.gb.financial.assistant.lib.data.operation.OperationDto;
import com.gb.financial.assistant.lib.data.operation.OperationSaveDto;

import java.util.List;

public interface FinancialOperationService {

    OperationDto getById(long id);

    List<OperationDto> getAll(boolean isSpending);

    long save(OperationSaveDto saveDto);

    void delete(long id);
}
