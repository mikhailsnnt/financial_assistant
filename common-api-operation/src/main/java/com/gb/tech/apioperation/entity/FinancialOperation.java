package com.gb.tech.apioperation.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "financial_operation")
public class FinancialOperation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

//    @ManyToOne
//    @JoinColumn(name = "account_id")
    @Column(name = "account_id")
    private Long account;

//    @ManyToOne
//    @JoinColumn(name = "operation_category_id")
    @Column(name = "operation_category_id")
    private Long operationCategory;

    @Column(name = "isspending")
    private Boolean isSpending;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "datetime")
    private LocalDateTime dateTime;


}
