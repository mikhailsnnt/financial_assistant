package com.gb.tech.financialassistant.controllers;


import com.gb.tech.financialassistant.dto.FinancialOperationDto;
import com.gb.tech.financialassistant.service.FinancialOperationServiceImp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/financialOperation")
public class FinancialOperationController {

    private final FinancialOperationServiceImp financialOperationServiceImp;


    public FinancialOperationController(FinancialOperationServiceImp financialOperationServiceImp) {
        this.financialOperationServiceImp = financialOperationServiceImp;
    }

    @GetMapping("/{id}")
    public FinancialOperationDto getById(@PathVariable Long id){
        return financialOperationServiceImp.getFinancialOperationById(id);
    }

    @GetMapping("/all")
    public List<FinancialOperationDto> getAll(){
        return financialOperationServiceImp.getAllFinancialOperation();
    }

    @GetMapping("/getAllIsSpending/{isSpending}")
    // переделать без пасвариабл, наверное через реквестпарам.
    public List<FinancialOperationDto> getAllFinancialOperationIsSpending(@PathVariable Boolean isSpending){
        return financialOperationServiceImp.getAllFinancialOperationIsSpending(isSpending);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> saveFinancialOperation(@RequestBody FinancialOperationDto financialOperationDto){

        financialOperationServiceImp.saveFinancialOperation(financialOperationDto);

        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping
    public void deleteFinancialOperation(@RequestBody Long id){
        financialOperationServiceImp.deleteFinancialOperation(id);
    }

//    @DeleteMapping("{id}")            это работает
//    public void deleteFinancialOperation(@PathVariable Long id){
//        financialOperationServiceImp.deleteFinancialOperation(id);
//    }
}
