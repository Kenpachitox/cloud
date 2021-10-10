package com.example.data;

import com.example.data.domain.Payment;
import com.example.data.repositories.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;



@SpringBootApplication
@Service
@RequiredArgsConstructor
public class DataApplication {
  public static void main(String[] args) {
    SpringApplication.run(DataApplication.class, args);
  }

  private final Log logger = LogFactory.getLog(this.getClass());
  private final PaymentRepository repository;

  @KafkaListener(groupId = "data", topics = "processedPayments")
  public void listen(Payment message) {
    logger.info(message);
    repository.save(message);
  }

}
