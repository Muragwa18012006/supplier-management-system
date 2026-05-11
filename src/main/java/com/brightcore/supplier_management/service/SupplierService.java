package com.brightcore.supplier_management.service;

import com.brightcore.supplier_management.dto.SupplierDto;

public interface SupplierService {

    SupplierDto.Response addSupplier(SupplierDto.Request request);

    SupplierDto.Response getSupplier(Long id);

    SupplierDto.Response updateSupplier(Long id, SupplierDto.Request request);

    void deleteSupplier(Long id);
}