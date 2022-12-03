package com.gb.tech.apioperation.controller;


import com.gb.tech.apioperation.dto.FinancialOperationDto;
import com.gb.tech.apioperation.service.FinancialOperationService;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationService financialOperationServiceImp;

    @GetMapping("/{id}")
    public FinancialOperationDto getById(@PathVariable ("id") Long id){
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
