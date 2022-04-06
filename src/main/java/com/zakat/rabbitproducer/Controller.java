package com.zakat.rabbitproducer;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    private final String EXCHANGE_NAME = "obmennik";

    @GetMapping("/gen/{number}")
public String produce(@PathVariable ("number") String number){
        System.out.println("Produce object: " + number);
IntDto intDto = new IntDto(Long.parseLong(number));


        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "rk", intDto);
        return "Ok!";
    }
}
