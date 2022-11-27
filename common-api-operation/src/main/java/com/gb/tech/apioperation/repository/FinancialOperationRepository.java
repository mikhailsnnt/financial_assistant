package com.gb.tech.apioperation.repository;

import com.gb.tech.apioperation.entity.FinancialOperation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FinancialOperationRepository extends JpaRepository<FinancialOperation, Long> {

    List<FinancialOperation> findAllByIsSpending(Boolean isSpending);

}
