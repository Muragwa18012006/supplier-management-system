package com.brightcore.supplier_management.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDateTime;

public class SupplierDto {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        @NotBlank(message = "Name is required")
        private String name;

        @Email(message = "Invalid email")
        private String email;

        @NotBlank(message = "Phone is required")
        private String phone;

        @NotBlank(message = "Company is required")
        private String company;

        @NotBlank(message = "Address is required")
        private String address;

        @NotBlank(message = "Supplier code is required")
        private String supplierCode;

        @NotBlank(message = "Contact person is required")
        private String contactPerson;

        @NotBlank(message = "Status is required")
        private String status;

        @NotBlank(message = "Supplied product is required")
        private String suppliedProduct;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {

        private Long id;

        private String name;

        private String email;

        private String phone;

        private String company;

        private String address;

        private String supplierCode;

        private String contactPerson;

        private String status;

        private String suppliedProduct;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;
    }
}