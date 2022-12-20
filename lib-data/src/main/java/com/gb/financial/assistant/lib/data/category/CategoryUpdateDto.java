package com.gb.financial.assistant.lib.data.category;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryUpdateDto {
    private String name;
    private OperationType operationType;
}
