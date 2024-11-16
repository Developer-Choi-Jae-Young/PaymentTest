package com.example.payment.controller;

import com.example.payment.service.PaymentService;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final PaymentService paymentService;

    @GetMapping("/verify/{imp_uid}")
    public IamportResponse<Payment> paymentTest(@PathVariable("imp_uid") String imp_uid) throws IamportResponseException, IOException {
        return paymentService.paymentTest(imp_uid);
    }
}
