package com.gb.tech.apioperation.mapper;

import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.dto.FinancialOperationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(
        componentModel = "spring"
)
public interface FinancialOperationMapper {

    FinancialOperation toFinancialOperation(FinancialOperationDto financialOperationdto);

    @InheritInverseConfiguration
    FinancialOperationDto fromFinancialOperation(FinancialOperation financialOperation);

    List<FinancialOperation> toFinancialOperationList(List<FinancialOperationDto> FinancialOperationDtos);

    List<FinancialOperationDto> fromFinancialOperationList(List<FinancialOperation> financialOperations);
}
