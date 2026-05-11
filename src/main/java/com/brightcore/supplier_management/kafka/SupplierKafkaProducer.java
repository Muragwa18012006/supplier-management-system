package com.brightcore.supplier_management.kafka;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SupplierKafkaProducer {

    private final KafkaTemplate<String, SupplierEvent> kafkaTemplate;

    private static final String TOPIC = "supplier-topic";

    public void publishEvent(SupplierEvent event) {

        kafkaTemplate.send(TOPIC, event);
    }
}