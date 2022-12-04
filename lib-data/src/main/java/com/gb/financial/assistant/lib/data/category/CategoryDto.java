package com.gb.financial.assistant.lib.data.category;

import lombok.Data;

@Data
public class CategoryDto {
    private Long id;
    private String name;
    private OperationType operationType;
}
