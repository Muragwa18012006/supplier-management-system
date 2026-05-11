package com.brightcore.supplier_management.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SupplierKafkaConsumer {

    @KafkaListener(
            topics = "supplier-topic",
            groupId = "supplier-group"
    )
    public void consume(SupplierEvent event) {

        System.out.println("================================");
        System.out.println("KAFKA EVENT RECEIVED");
        System.out.println("Event Type: " + event.getEventType());
        System.out.println("Supplier ID: " + event.getSupplierId());
        System.out.println("Message: " + event.getMessage());
        System.out.println("================================");
    }
}