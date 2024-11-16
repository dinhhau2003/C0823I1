package com.example.projectc1023i1.controller.product;


import com.example.projectc1023i1.model.product.Table;
import com.example.projectc1023i1.service.product.TableService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/table")
public class TableController {
    @Autowired
    private TableService tableService;

    @GetMapping("")
    public ResponseEntity<List<Table>> findAllTable(@RequestParam(defaultValue = "0",required = false) int page
    ){
        Pageable pageable= PageRequest.of(page,10);
        Page<Table> tableList = tableService.findAllTable(pageable);
        if(tableList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tableList.getContent(),HttpStatus.OK);
        }
    }

    @GetMapping("/code/{table_code}")
    public ResponseEntity<List<Table>> findTableByCode(@PathVariable("table_code") String table_code,
                                                      @RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Table> tablePage = tableService.findTableByCode(table_code, pageable);

        if (tablePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tablePage.getContent(), HttpStatus.OK);
        }
    }
    @GetMapping("/status/{status}")
    public ResponseEntity<List<Table>> findAllTableByStatus(@PathVariable("status") boolean status,
                                                            @RequestParam(defaultValue = "0", required = false) int page) {
        Pageable pageable = PageRequest.of(page, 4);
        Page<Table> tablePage = tableService.findTableByStatus(status, pageable);

        if (tablePage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tablePage.getContent(), HttpStatus.OK); // Trả về danh sách bảng
        }
    }

      @DeleteMapping("/delete/{id}")
  public ResponseEntity<String> delete(@PathVariable("id") int id) {
    boolean isDeleted = tableService.deleteTableById(id);

    if (isDeleted) {
        return ResponseEntity.ok("Table with ID " + id + " has been deleted successfully.");
    } else {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Table with ID " + id + " not found.");
    }
}

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateTable(@PathVariable("id") int tableId, @RequestParam boolean newStatus) {
        boolean isUpdated = tableService.updateTableById(tableId, newStatus);

        if (isUpdated) {
            return ResponseEntity.ok("Table with ID " + tableId + " has been updated successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Table with ID " + tableId + " not found.");
        }
    }
    @PostMapping("/create")
    public ResponseEntity<String> createTable(@RequestBody Table table) {
        try {
            tableService.createTable(table.getCode(),table.getTableName(),table.isStatus());
            return ResponseEntity.status(HttpStatus.CREATED).body("Table created successfully.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error occurred while creating the table: " + e.getMessage());
        }
    }




}
