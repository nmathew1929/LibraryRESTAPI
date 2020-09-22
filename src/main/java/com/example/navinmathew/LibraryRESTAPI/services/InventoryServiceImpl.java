package com.example.navinmathew.LibraryRESTAPI.services;

import com.example.navinmathew.LibraryRESTAPI.domain.Inventory;
import com.example.navinmathew.LibraryRESTAPI.repositories.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService {

    private final InventoryRepository inventoryRepository;

    public InventoryServiceImpl(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }


    @Override
    public Inventory findInventoryEntryById(Long id) {
        return inventoryRepository.findById(id).get();
    }

    @Override
    public List<Inventory> findInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public Inventory saveInventoryEntry(Inventory inventory) {
        return inventoryRepository.save(inventory) ;
    }

    @Override
    public void deleteInventoryEntry(Long id) {
        inventoryRepository.deleteById(id);
    }
}
