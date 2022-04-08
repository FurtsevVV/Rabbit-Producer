package com.zakat.rabbitproducer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    private RabbitTemplate rabbitTemplate;
    private ServiceFromRabbit serviceFromRabbit;


    @Autowired
    public void setRabbitTemplate(RabbitTemplate rabbitTemplate, ServiceFromRabbit serviceFromRabbit){
        this.rabbitTemplate = rabbitTemplate;
        this.serviceFromRabbit = serviceFromRabbit;
    }

@RabbitListener(queues = "queue2")
    public void receiveMessage(Message message){
        System.out.println("Get message: " + message);
        serviceFromRabbit.returnMessageToFront(message);
    }
}
