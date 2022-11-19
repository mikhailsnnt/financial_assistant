package com.gb.tech.financialassistant.repository;

import com.gb.tech.financialassistant.entity.FinancialOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialOperationRepository extends JpaRepository<FinancialOperation, Long> {

    List<FinancialOperation> findAllByIsSpending(Boolean isSpending);

}
