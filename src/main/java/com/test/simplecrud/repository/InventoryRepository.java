package com.test.simplecrud.repository;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.test.simplecrud.model.Inventory;

@Repository
public class InventoryRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public InventoryRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getAllInventories() {
        String query = "SELECT * FROM inventory";
        return jdbcTemplate.queryForList(query);
    }

    public Map<String, Object> getInventoryById(Long id) {
        String query = "SELECT * FROM inventory WHERE id = ?";
        return jdbcTemplate.queryForMap(query, id);
    }

    public Long createInventory(Inventory inventory) {
        String insertQuery = "INSERT INTO inventory (name, stock, price) VALUES (?, ?, ?)";
        jdbcTemplate.update(insertQuery, inventory.getName(), inventory.getStock(), inventory.getPrice());
        return jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Long.class);
    }

    public int updateInventory(Long id, Inventory inventory) {
        String updateQuery = "UPDATE inventory SET name = ?, stock = ?, price = ? WHERE id = ?";
        return jdbcTemplate.update(updateQuery, inventory.getName(), inventory.getStock(), inventory.getPrice(), id);
    }

    public int deleteInventory(Long id) {
        String deleteQuery = "DELETE FROM inventory WHERE id = ?";
        return jdbcTemplate.update(deleteQuery, id);
    }
}

