package com.brightcore.supplier_management.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic supplierTopic() {

        return new NewTopic(
                "supplier-topic",
                1,
                (short) 1
        );
    }
}