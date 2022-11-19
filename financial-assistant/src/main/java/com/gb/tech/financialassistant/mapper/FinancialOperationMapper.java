package com.gb.tech.financialassistant.mapper;

import com.gb.tech.financialassistant.entity.FinancialOperation;
import com.gb.tech.financialassistant.dto.FinancialOperationDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface FinancialOperationMapper {

    FinancialOperationMapper MAPPER = Mappers.getMapper(FinancialOperationMapper.class);

    FinancialOperation toFinancialOperation(FinancialOperationDto financialOperationdto);

    @InheritInverseConfiguration
    FinancialOperationDto fromFinancialOperation(FinancialOperation financialOperation);

    List<FinancialOperation> toFinancialOperationList(List<FinancialOperationDto> FinancialOperationDtos);

    List<FinancialOperationDto> fromFinancialOperationList(List<FinancialOperation> financialOperations);
}
