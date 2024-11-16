package com.example.payment.service;

import com.siot.IamportRestClient.IamportClient;
import com.siot.IamportRestClient.exception.IamportResponseException;
import com.siot.IamportRestClient.response.IamportResponse;
import com.siot.IamportRestClient.response.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
@Slf4j
public class PaymentService {
    private final IamportClient iamport;

    public IamportResponse<Payment> paymentTest(String uid) throws IamportResponseException, IOException {
        IamportResponse<Payment> response = iamport.paymentByImpUid(uid);
        log.info("Amount = {}",response.getResponse().getAmount());
        log.info("Name = {}", response.getResponse().getName());
        log.info("Status = {}", response.getResponse().getStatus());
        return response;
    }
}
