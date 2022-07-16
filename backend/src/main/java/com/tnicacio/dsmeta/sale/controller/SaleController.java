package com.tnicacio.dsmeta.sale.controller;

import com.tnicacio.dsmeta.sale.entity.SaleEntity;
import com.tnicacio.dsmeta.sale.service.SaleService;
import com.tnicacio.dsmeta.sms.service.SmsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {

    private final SaleService saleService;
    private final SmsService smsService;

    public SaleController(SaleService saleService, SmsService smsService) {
        this.saleService = saleService;
        this.smsService = smsService;
    }

    @GetMapping
    public ResponseEntity<Page<SaleEntity>> findSales(@RequestParam(value = "minDate", defaultValue = "") String minDate,
                                                      @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
                                                      Pageable pageable) {
        return ResponseEntity.ok(saleService.findSales(minDate, maxDate, pageable));
    }

    @PostMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
}
