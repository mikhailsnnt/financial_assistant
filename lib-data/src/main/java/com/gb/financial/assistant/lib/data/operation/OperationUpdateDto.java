package com.gb.financial.assistant.lib.data.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationUpdateDto {
    private Long accountId;
    private Long operationCategoryId;
    private Long isSpending;
    private BigDecimal amount;
    private LocalDateTime dateTime;
}
