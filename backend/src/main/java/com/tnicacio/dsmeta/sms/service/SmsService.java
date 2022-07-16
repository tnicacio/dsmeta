package com.tnicacio.dsmeta.sms.service;

import com.tnicacio.dsmeta.sale.repository.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    @Value("${twilio.sid}")
    private String twilioSid;

    @Value("${twilio.key}")
    private String twilioKey;

    @Value("${twilio.phone.from}")
    private String twilioPhoneFrom;

    @Value("${twilio.phone.to}")
    private String twilioPhoneTo;

    private final SaleRepository saleRepository;

    public SmsService(SaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    public void sendSms(Long saleId) {
        saleRepository.findById(saleId)
                .ifPresent(sale -> {
                    String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
                    String messageBody = "O vendedor " + sale.getSellerName() + " foi destaque em " + date
                            + " com um total de R$ " + String.format("%.2f", sale.getAmount());

                    Twilio.init(twilioSid, twilioKey);

                    PhoneNumber to = new PhoneNumber(twilioPhoneTo);
                    PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

                    Message message = Message.creator(to, from, messageBody).create();

                    System.out.println(message.getSid());
                });
    }
}
