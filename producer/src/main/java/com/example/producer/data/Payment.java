package com.example.producer.data;

import com.example.producer.validator.CardNumber;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Payment implements Payload {
  private long id;
  private long senderId;
  @CardNumber
  private String senderCardNumber;
  @CardNumber
  private String recipientCardNumber;
  @NotBlank
  @NotNull
  @Min(1)
  private long amount;
  private String comment;
}
