package com.gb.tech.apioperation.controller;

import com.gb.financial.assistant.lib.data.operation.OperationDto;
import com.gb.financial.assistant.lib.data.operation.OperationSaveDto;
import com.gb.tech.apioperation.service.FinancialOperationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/operation")
public class FinancialOperationController {

    private final FinancialOperationService service;

    @GetMapping("/{id}")
    public OperationDto getById(@PathVariable long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<OperationDto> getAll(@RequestParam(required = false, defaultValue = "false") boolean isSpending) {
        return service.getAll(isSpending);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public long save(@Valid @RequestBody OperationSaveDto operationDto) {
        return service.save(operationDto);
    }

    @DeleteMapping
    public void delete(@RequestParam Long id) {
        service.delete(id);
    }
}
