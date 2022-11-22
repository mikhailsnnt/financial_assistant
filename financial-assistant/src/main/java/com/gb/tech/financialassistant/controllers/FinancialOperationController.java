package com.gb.tech.financialassistant.controllers;


import com.gb.tech.financialassistant.dto.FinancialOperationDto;
import com.gb.tech.financialassistant.service.FinancialOperationService;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationService financialOperationServiceImp;

    @GetMapping("/id")  // TODO через строку запроса
    public FinancialOperationDto getById(@RequestParam Long id){
        return financialOperationServiceImp.getById(id);
    }

    @GetMapping
    public List<FinancialOperationDto> getAll(@RequestParam boolean isSpending){
        return financialOperationServiceImp.getAll(isSpending);
    }


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody FinancialOperationDto financialOperationDto){
        financialOperationServiceImp.save(financialOperationDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id){
        financialOperationServiceImp.delete(id);
    }


}
