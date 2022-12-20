package com.gb.tech.apioperation.mapper;

import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.entity.FinancialOperation;

import java.util.ArrayList;
import java.util.List;

public class FinancialOperationMapper {

    private static FinancialOperationDto financialOperationDto;

    public static FinancialOperation toFinancialOperation(FinancialOperationDto financialOperationDto) {

        if ( financialOperationDto == null ) {
            return null;
        }
        return new FinancialOperation(financialOperationDto.getId(),
                financialOperationDto.getAccountId(),
                financialOperationDto.getOperationCategoryId(),
                financialOperationDto.getIsSpending(),
                financialOperationDto.getAmount(),
                financialOperationDto.getDateTime()
        );
    }

    public static FinancialOperationDto fromFinancialOperation(FinancialOperation financialOperation) {

        if ( financialOperation == null ) {
            return null;
        }
        return new FinancialOperationDto(financialOperation.getId(),
                financialOperation.getAccountId(),
                financialOperation.getOperationCategoryId(),
                financialOperation.getIsSpending(),
                financialOperation.getAmount(),
                financialOperation.getDateTime()
        );
    }

    public static List<FinancialOperationDto> fromFinancialOperationList(List<FinancialOperation> financialOperations){

        if ( financialOperations == null ) {
            return null;
        }
        List<FinancialOperationDto> listDto = new ArrayList<>(financialOperations.size());
        for (FinancialOperation financialOperation: financialOperations) {
            listDto.add(fromFinancialOperation(financialOperation));
        }
        return listDto;
    }
}
