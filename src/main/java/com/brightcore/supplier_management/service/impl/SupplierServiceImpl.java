package com.brightcore.supplier_management.service.impl;

import com.brightcore.supplier_management.dto.SupplierDto;
import com.brightcore.supplier_management.entity.Supplier;
import com.brightcore.supplier_management.repository.SupplierRepository;
import com.brightcore.supplier_management.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.brightcore.supplier_management.exception.ResourceNotFoundException;
import com.brightcore.supplier_management.kafka.SupplierEvent;
import com.brightcore.supplier_management.kafka.SupplierKafkaProducer;

@Service
@RequiredArgsConstructor
public class SupplierServiceImpl implements SupplierService {

    private final SupplierRepository supplierRepository;
    private final SupplierKafkaProducer kafkaProducer;

    @Override
    public SupplierDto.Response addSupplier(SupplierDto.Request request) {

        Supplier supplier = Supplier.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phone(request.getPhone())
                .company(request.getCompany())
                .address(request.getAddress())
                .build();

        Supplier savedSupplier = supplierRepository.save(supplier);
        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_CREATED")
                .supplierId(savedSupplier.getId())
                .message("Supplier created successfully")
                .build();

        kafkaProducer.publishEvent(event);

        return SupplierDto.Response.builder()
                .id(savedSupplier.getId())
                .name(savedSupplier.getName())
                .email(savedSupplier.getEmail())
                .phone(savedSupplier.getPhone())
                .company(savedSupplier.getCompany())
                .address(savedSupplier.getAddress())
                .build();
    }

    @Override
    public SupplierDto.Response getSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        return SupplierDto.Response.builder()
                .id(supplier.getId())
                .name(supplier.getName())
                .email(supplier.getEmail())
                .phone(supplier.getPhone())
                .company(supplier.getCompany())
                .address(supplier.getAddress())
                .build();
    }

    @Override
    public SupplierDto.Response updateSupplier(Long id, SupplierDto.Request request) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        supplier.setName(request.getName());
        supplier.setEmail(request.getEmail());
        supplier.setPhone(request.getPhone());
        supplier.setCompany(request.getCompany());
        supplier.setAddress(request.getAddress());

        Supplier updatedSupplier = supplierRepository.save(supplier);
        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_UPDATED")
                .supplierId(updatedSupplier.getId())
                .message("Supplier updated successfully")
                .build();

        kafkaProducer.publishEvent(event);

        return SupplierDto.Response.builder()
                .id(updatedSupplier.getId())
                .name(updatedSupplier.getName())
                .email(updatedSupplier.getEmail())
                .phone(updatedSupplier.getPhone())
                .company(updatedSupplier.getCompany())
                .address(updatedSupplier.getAddress())
                .build();
    }

    @Override
    public void deleteSupplier(Long id) {

        Supplier supplier = supplierRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Supplier not found"));

        SupplierEvent event = SupplierEvent.builder()
                .eventType("SUPPLIER_DELETED")
                .supplierId(supplier.getId())
                .message("Supplier deleted successfully")
                .build();

        kafkaProducer.publishEvent(event);
        supplierRepository.delete(supplier);
    }
}