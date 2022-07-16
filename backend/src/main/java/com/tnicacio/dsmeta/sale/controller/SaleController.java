package com.tnicacio.dsmeta.sale.controller;

import com.tnicacio.dsmeta.sale.entity.SaleEntity;
import com.tnicacio.dsmeta.sale.service.SaleService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping
    public ResponseEntity<Page<SaleEntity>> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                      @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                                      Pageable pageable) {
        return ResponseEntity.ok(saleService.findSales(minDate, maxDate, pageable));
    }
}
