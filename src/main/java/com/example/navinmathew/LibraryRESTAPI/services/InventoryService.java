package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.Inventory;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface InventoryService {

    Inventory findInventoryEntryById(Long id);
    List<Inventory> findInventory();
    Inventory saveInventoryEntry(Inventory inventory);
    void deleteInventoryEntry(Long id);
}
