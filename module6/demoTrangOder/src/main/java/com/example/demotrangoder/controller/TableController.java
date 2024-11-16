package com.example.demotrangoder.controller;

import com.example.demotrangoder.model.Table;
import com.example.demotrangoder.service.ITableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/table")
public class TableController {
    @Autowired
    private ITableService tableService;
    @GetMapping("")
    public ResponseEntity<List<Table>> findAllTable(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {

        Pageable pageable = PageRequest.of(page, size);
        Page<Table> tables = tableService.findAll(pageable);

        return ResponseEntity.ok(tables.getContent());  // Trả về danh sách các Table trong nội dung trang
    }
    @GetMapping("/{id}")
    public ResponseEntity<Table> getTableById(@PathVariable Long id) {
        Optional<Table> table = tableService.findById(id);
        if (table.isPresent()) {
            return ResponseEntity.ok(table.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
