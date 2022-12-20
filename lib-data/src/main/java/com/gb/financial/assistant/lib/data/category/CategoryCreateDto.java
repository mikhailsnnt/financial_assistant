package com.gb.financial.assistant.lib.data.category;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryCreateDto {
    @NotBlank(message = "Category name is mandatory, and must not be blank")
    private String name;
    @NotNull(message = "Operation type is not specified")
    private OperationType operationType;
}
