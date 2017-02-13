package com.jdafda;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ComplaintApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComplaintApplication.class, args);
    }


    @Bean
    public Exchange exchange() {
        return ExchangeBuilder.fanoutExchange("ComplaintEvents").build();
    }

    @Bean
    public Queue queue() {
        return QueueBuilder.durable("ComplaintEvents").build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind(queue()).to(exchange()).with("*").noargs();
    }

    @Autowired
    public void configure(AmqpAdmin amqpAdmin) {
        amqpAdmin.declareExchange(exchange());
        amqpAdmin.declareQueue(queue());
        amqpAdmin.declareBinding(binding());
    }

}



