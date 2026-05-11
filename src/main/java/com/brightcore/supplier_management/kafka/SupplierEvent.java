package com.brightcore.supplier_management.kafka;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SupplierEvent {

    private String eventType;

    private Long supplierId;

    private String message;
}