package com.gb.tech.apioperation.controller;


import com.gb.financial.assistant.lib.exception.security.BadCredentialsException;
import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.mapper.FinancialOperationMapper;
import com.gb.tech.apioperation.repository.AccountGateway;
import com.gb.tech.apioperation.service.FinancialOperationService;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationService financialOperationServiceImp;
    private final FinancialOperationMapper mapper = FinancialOperationMapper.MAPPER;
    private final AccountGateway accountGateway;

    @GetMapping("/{id}")
    public FinancialOperationDto getById(@PathVariable ("id") Long id){
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
