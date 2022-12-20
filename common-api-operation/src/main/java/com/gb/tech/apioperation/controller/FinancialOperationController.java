package com.gb.tech.apioperation.controller;

import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.entity.FinancialOperation;
import com.gb.tech.apioperation.mapper.FinancialOperationMapper;
import com.gb.tech.apioperation.service.AccountGateway;
import com.gb.tech.apioperation.service.FinancialOperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationService financialOperationServiceImp;
    private final AccountGateway accountGateway;

    @GetMapping("/{id}")
    public FinancialOperationDto getById(@PathVariable long id){
        FinancialOperation financialOperation = financialOperationServiceImp.getById(id);
        accountGateway.getById(financialOperation.getAccountId());
        return FinancialOperationMapper.fromFinancialOperation(financialOperation);
    }

    @GetMapping
    public List<FinancialOperationDto> getAll(@RequestParam boolean isSpending){
        List<Object> list = accountGateway.getAll(Long.valueOf(SecurityContextHolder.getContext().getAuthentication().getName()));
        // ToDo

        return null;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody FinancialOperationDto financialOperationDto){
        accountGateway.getById(financialOperationDto.getAccountId());
        financialOperationServiceImp.save(FinancialOperationMapper.toFinancialOperation(financialOperationDto));
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        FinancialOperation financialOperation = financialOperationServiceImp.getById(id);
        accountGateway.getById(financialOperation.getAccountId());
        financialOperationServiceImp.delete(id);
    }

}
