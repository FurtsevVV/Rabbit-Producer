package com.zakat.rabbitproducer;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.messaging.handler.annotation.support.MessageHandlerMethodFactory;

@Configuration
public class RabbitConfiguration  {


    private final String EXCHANGE_NAME = "obmennik";


    @Bean
    Queue queue1(){
        return new Queue("queue1", false);
    }

    @Bean
    Queue queue2(){
        return new Queue("queue2", false);
    }

    @Bean
    TopicExchange topicExchange(){
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Binding bindingQueue1(@Qualifier("queue1") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("rk");
    }

    @Bean
    Binding bindingQueue2(@Qualifier("queue2") Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("rkb");
    }


    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

}
