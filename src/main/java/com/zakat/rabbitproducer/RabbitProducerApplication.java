package com.zakat.rabbitproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
public class RabbitProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitProducerApplication.class, args);
    }

}
