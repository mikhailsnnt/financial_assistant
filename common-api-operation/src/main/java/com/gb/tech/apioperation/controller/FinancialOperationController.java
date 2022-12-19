package com.gb.tech.apioperation.controller;


import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.mapper.FinancialOperationMapper;
import com.gb.tech.apioperation.service.AccountGateway;
import com.gb.tech.apioperation.service.FinancialOperationService;


import lombok.AllArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationMapper mapper;
    private final FinancialOperationService financialOperationServiceImp;
    private final AccountGateway accountGateway;

    @GetMapping("/{id}")
    public FinancialOperationDto getById(@PathVariable long id){
        FinancialOperation financialOperation = financialOperationServiceImp.getById(id);
        if (accountGateway.getUserId(financialOperation.getAccountId())
                .equals(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))){
            return mapper.fromFinancialOperation(financialOperation);
        }
        return null;
    }

    @GetMapping
    public List<FinancialOperationDto> getAll(@RequestParam boolean isSpending){
        accountGateway.getAccountId(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()));
        return mapper.fromFinancialOperationList(financialOperationServiceImp.getAll(isSpending
                , accountGateway.getAccountId(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody FinancialOperationDto financialOperationDto){
        if (accountGateway.getUserId(financialOperationDto.getAccountId())
                .equals(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))) {
            financialOperationServiceImp.save(mapper.toFinancialOperation(financialOperationDto));
        }
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        FinancialOperation financialOperation = financialOperationServiceImp.getById(id);
        if (accountGateway.getUserId(financialOperation.getAccountId())
                .equals(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()))){
            financialOperationServiceImp.delete(id);
        }
    }

}
