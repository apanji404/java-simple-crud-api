package com.test.simplecrud.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.simplecrud.model.Inventory;
import com.test.simplecrud.repository.InventoryRepository;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    @Autowired
    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<Map<String, Object>> getAllInventories() {
        return inventoryRepository.getAllInventories();
    }

    public Map<String, Object> getInventoryById(Long id) {
        return inventoryRepository.getInventoryById(id);
    }

    public Long createInventory(Inventory inventory) {
        return inventoryRepository.createInventory(inventory);
    }

    public int updateInventory(Long id, Inventory inventory) {
        return inventoryRepository.updateInventory(id, inventory);
    }

    public int deleteInventory(Long id) {
        return inventoryRepository.deleteInventory(id);
    }
}

