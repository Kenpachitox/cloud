package com.example.producer;

import com.example.producer.data.Payment;
import com.example.producer.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequiredArgsConstructor
public class KafkaProducerApplication {
  private final PaymentService service;

  public static void main(String[] args) {
    SpringApplication.run(KafkaProducerApplication.class, args);
  }

  @Bean
  public NewTopic messagesTopic() {
    return new NewTopic("payments", 3, (short)2);
  }

  @PostMapping("/payments")
  public void send(@RequestBody Payment payment) {
    service.send(payment);
  }

}
