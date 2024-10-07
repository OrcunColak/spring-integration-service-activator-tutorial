package com.colak.springtutorial.config;

import com.colak.springtutorial.service.ServiceHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.handler.ServiceActivatingHandler;
import org.springframework.messaging.MessageChannel;

// @Configuration
// @EnableIntegration
public class IntegrationConfig {

    @Bean
    public MessageChannel inputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel outputChannel() {
        return new DirectChannel();
    }

    @Bean
    public IntegrationFlow serviceActivatorFlow() {
        return IntegrationFlow.from(inputChannel())
                .handle(new ServiceActivatingHandler(new ServiceHandler()))
                .channel(outputChannel())
                .get();
    }

}

