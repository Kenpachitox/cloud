package com.example.data.service;

import com.example.data.domain.Payment;
import com.example.data.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository repository;

    public List<Payment> getPaymentsList(int paymentNumbers){
        return repository.getPaymentsList(paymentNumbers);
    }
}