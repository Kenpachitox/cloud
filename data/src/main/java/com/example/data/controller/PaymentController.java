package com.example.data.controller;

import com.example.data.domain.Payment;
import com.example.data.dto.ResponseDto;
import com.example.data.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Value;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PaymentController {
    private final Log logger = LogFactory.getLog(this.getClass());
    private final PaymentService service;

    @Setter(onMethod_={@Value("${app.id}")})
    private String id;


    @GetMapping
    public ResponseDto endpoint(@RequestHeader Optional<String> authorization) {
        logger.info("Request on data");
        return new ResponseDto(id);
    }

    @GetMapping("/payments/{paymentNumbers}")
    List<Payment> getList(@PathVariable int paymentNumbers){
        return service.getPaymentsList(paymentNumbers);
    }
}
