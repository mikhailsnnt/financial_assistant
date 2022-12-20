package com.gb.financial.assistant.lib.dto;

import com.gb.financial.assistant.lib.data.category.OperationType;
import lombok.Data;

@Data
public class CategoryUpdateDto {
    private String name;
    private OperationType operationType;
}
