package com.example.aggregator.controller;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentWithUsername;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import com.example.aggregator.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController("/api")
@EnableFeignClients
@RequiredArgsConstructor
public class PaymentController {
    private final DiscoveryClient discoveryClient;
    private final PaymentService service;
    private final int PAYMENT_NUMBRER = 1000;

    @GetMapping("/value")
    public ResponseDto value() {
        return service.getValue();
    }

    @GetMapping("/payments")
    public List<PaymentWithUsername> stats() {
        return service.getStat(PAYMENT_NUMBRER);
    }

    @GetMapping("/users")
    public List<UserDto> users() {
        return service.getUsers();
    }

}
