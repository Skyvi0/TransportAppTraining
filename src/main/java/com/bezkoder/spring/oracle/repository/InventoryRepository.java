package com.bezkoder.spring.oracle.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bezkoder.spring.oracle.model.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
  List<Inventory> findByTitleContaining(String title);
}
