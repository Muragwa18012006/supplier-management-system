package com.brightcore.supplier_management.controller;

import com.brightcore.supplier_management.dto.SupplierDto;
import com.brightcore.supplier_management.service.SupplierService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/api/v1/suppliers")
@RequiredArgsConstructor
public class SupplierController {

    private final SupplierService supplierService;

    @Operation(summary = "Create a new supplier")
    @PostMapping("/add")
    public ResponseEntity<SupplierDto.Response> addSupplier(
            @Valid @RequestBody SupplierDto.Request request
    ) {

        SupplierDto.Response response = supplierService.addSupplier(request);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @Operation(summary = "Get supplier by ID")
    @GetMapping("/{id}")
    public ResponseEntity<SupplierDto.Response> getSupplier(
            @PathVariable Long id
    ) {

        SupplierDto.Response response = supplierService.getSupplier(id);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Update supplier")
    @PutMapping("/update/{id}")
    public ResponseEntity<SupplierDto.Response> updateSupplier(
            @PathVariable Long id,
            @Valid @RequestBody SupplierDto.Request request
    ) {

        SupplierDto.Response response =
                supplierService.updateSupplier(id, request);

        return ResponseEntity.ok(response);
    }

    @Operation(summary = "Delete supplier")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteSupplier(
            @PathVariable Long id
    ) {

        supplierService.deleteSupplier(id);

        return ResponseEntity.ok("Supplier deleted successfully");
    }
}