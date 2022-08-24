package com.example.cashedandcustomer.schedule;

import com.example.cashedandcustomer.Models.UserBalance;
import com.example.cashedandcustomer.repository.UserBalanceRepository;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ClientBalancePublisher {
    @Value("${K}")
    private int K;
    @Value("${M}")
    private int M;
    @Autowired
    final RabbitTemplate rabbitTemplate;
    @Autowired
    AmqpTemplate amqpTemplate;
    @Autowired
    UserBalanceRepository userBalanceRepository;

    public ClientBalancePublisher(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Scheduled(fixedDelayString = "${M}")
    public void userBalancePublisher() {//заполняем очередь
       List<UserBalance>userBalanceList= userBalanceRepository.findByValueAfter(K);
        for (UserBalance i: userBalanceList) {
            amqpTemplate.convertAndSend("queue" , i);
        }

    }


}
