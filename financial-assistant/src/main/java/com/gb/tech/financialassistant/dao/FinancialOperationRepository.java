package com.gb.tech.financialassistant.dao;

import com.gb.tech.financialassistant.domain.FinancialOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialOperationRepository extends JpaRepository<FinancialOperation, Long> {

    List<FinancialOperation> findAllByIsSpending(Boolean isSpending);

}
