package com.example.aggregator.service;

import com.example.aggregator.client.DataClient;
import com.example.aggregator.client.UserClient;
import com.example.aggregator.dto.PaymentWithUsername;
import com.example.aggregator.dto.ResponseDto;
import com.example.aggregator.dto.UserDto;
import lombok.RequiredArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class PaymentService {
    private final DataClient dataClient;
    private final UserClient userClient;



    public List<PaymentWithUsername> getStat(int paymentNumbers) {
        final var payments = dataClient.getList(paymentNumbers);
        LinkedList<Long> usersIdList = new LinkedList<>();
        payments.forEach(p -> usersIdList.add(p.getSenderId()));
        final var userDtoList = userClient.getUsers(usersIdList);
        return payments.stream().map(p ->
                new PaymentWithUsername(p.getSenderId(), p.getAmount(),
                        userDtoList.get((int) p.getId()).getUsername(),
                        p.getComment())).collect(Collectors.toList());
    }

    public List<UserDto> getUsers() {
        return userClient.getUsers();
    }

    public ResponseDto getValue() {
        return dataClient.getValue();
    }
}
