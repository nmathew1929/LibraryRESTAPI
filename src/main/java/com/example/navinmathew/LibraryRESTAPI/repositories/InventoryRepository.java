package com.example.navinmathew.LibraryRESTAPI.repositories;

import com.example.navinmathew.LibraryRESTAPI.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
