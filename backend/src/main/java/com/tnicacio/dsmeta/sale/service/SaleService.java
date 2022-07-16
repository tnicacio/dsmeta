package com.tnicacio.dsmeta.sale.service;

import com.tnicacio.dsmeta.sale.entity.SaleEntity;
import com.tnicacio.dsmeta.sale.repository.SaleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class SaleService {

    private final SaleRepository saleRepository;

    public SaleService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public Page<SaleEntity> findSales(String minDate, String maxDate, Pageable pageable) {
        LocalDate today = LocalDate.now();
        LocalDate minLocalDate = "".equals(minDate) ? today.minusYears(1) : LocalDate.parse(minDate);
        LocalDate maxLocalDate = "".equals(maxDate) ? today : LocalDate.parse(maxDate);
        return saleRepository.findSalesByDateBetweenOrderByAmountDesc(minLocalDate, maxLocalDate, pageable);
    }
}
