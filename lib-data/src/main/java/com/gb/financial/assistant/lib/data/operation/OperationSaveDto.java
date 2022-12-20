package com.gb.financial.assistant.lib.data.operation;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationSaveDto {
    private long accountId;
    private long operationCategoryId;
    private boolean isSpending;
    @NotNull
    private BigDecimal amount;
    @NotNull
    private LocalDateTime dateTime;
}
