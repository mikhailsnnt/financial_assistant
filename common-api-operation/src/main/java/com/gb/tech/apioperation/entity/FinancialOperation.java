package com.gb.tech.apioperation.entity;

import lombok.Builder;
import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Builder
@Table(name = "financial_operation")
public class FinancialOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "account_id")
    private Long accountId;

    @Column(name = "operation_category_id")
    private Long operationCategoryId;

    @Column(name = "isspending")
    private Boolean isSpending;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "datetime")
    private LocalDateTime dateTime;
}
