package com.tnicacio.dsmeta.sale.repository;

import com.tnicacio.dsmeta.sale.entity.SaleEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.UUID;

@Repository
public interface SaleRepository extends JpaRepository<SaleEntity, UUID> {

    //    @Query("SELECT sale FROM SaleEntity sale WHERE sale.date BETWEEN :minDate AND :maxDate ORDER BY sale.amount
    //    DESC")
    Page<SaleEntity> findSalesByDateBetweenOrderByAmountDesc(LocalDate minDate, LocalDate maxDate, Pageable pageable);
}
