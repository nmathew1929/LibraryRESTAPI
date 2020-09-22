package com.example.navinmathew.LibraryRESTAPI.controllers;

import com.example.navinmathew.LibraryRESTAPI.domain.Category;
import com.example.navinmathew.LibraryRESTAPI.domain.Inventory;
import com.example.navinmathew.LibraryRESTAPI.domain.User;
import com.example.navinmathew.LibraryRESTAPI.services.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(InventoryController.BASE_URL)
public class InventoryController {
    public static final String BASE_URL = "/api/v1/inventory";

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }


    @GetMapping
    public List<Inventory> getInventory() {
       return inventoryService.findInventory();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.findInventoryEntryById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory createInventoryEntry(@RequestBody Inventory inventory) {
        return inventoryService.saveInventoryEntry(inventory);
    }

    /** shouldn't be able to change inventoryEntry, either add or delete.
    @PutMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Inventory updateInventoryEntry(@RequestBody Inventory inventoryEntry) {
        return inventoryService.saveInventoryEntry(inventoryEntry);
    }
    **/

@ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteInventoryEntry(@PathVariable Long id) {
        inventoryService.deleteInventoryEntry(id);
    }
}






