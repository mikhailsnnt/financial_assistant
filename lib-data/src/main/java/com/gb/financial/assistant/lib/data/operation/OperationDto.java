package com.gb.financial.assistant.lib.data.operation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {

    private long id;
    private long accountId;
    private long operationCategoryId;
    private boolean isSpending;
    private BigDecimal amount;
    private LocalDateTime dateTime;

}
