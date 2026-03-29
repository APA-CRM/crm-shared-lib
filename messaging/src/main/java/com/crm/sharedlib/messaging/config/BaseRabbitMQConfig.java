package com.crm.sharedlib.messaging.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.ConsumerTagStrategy;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static java.util.Objects.nonNull;

public abstract class BaseRabbitMQConfig {

    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    @Bean
    public ConnectionFactory connectionFactory(
            @Value("${spring.rabbitmq.host}") String host,
            @Value("${spring.rabbitmq.port}") Integer port,
            @Value("${spring.rabbitmq.username:#{null}}") String username,
            @Value("${spring.rabbitmq.password:#{null}}") String password
    ) {
        CachingConnectionFactory factory = new CachingConnectionFactory(host, port);

        if (nonNull(username)) {
            factory.setUsername(username);
        }
        if (nonNull(password)) {
            factory.setPassword(password);
        }

        return factory;
    }

    @Bean
    public ConsumerTagStrategy consumerTagStrategy(
            @Value("${spring.application.name}") String applicationName
    ) {
        return queue -> applicationName;
    }

    @Bean
    public AmqpTemplate amqpTemplate(
            MessageConverter messageConverter,
            ConnectionFactory connectionFactory
    ) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate();
        rabbitTemplate.setMessageConverter(messageConverter);
        rabbitTemplate.setConnectionFactory(connectionFactory);

        return rabbitTemplate;
    }

    @Bean
    public AmqpAdmin amqpAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

}
