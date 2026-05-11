package com.brightcore.supplier_management.repository;

import com.brightcore.supplier_management.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}