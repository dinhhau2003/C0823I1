package com.example.websocket.Controller;

import com.example.websocket.Entity.TableInfo;
import com.example.websocket.Repo.TableInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")  // Chỉ cho phép frontend từ localhost:3000

@RequestMapping("/api/tables")
public class TableInfoController {

    @Autowired
    private TableInfoRepository tableInfoRepository;

    // API để lấy tất cả thông tin bàn
    @GetMapping
    public List<TableInfo> getAllTables() {
        return tableInfoRepository.findAll(); // Lấy tất cả các bàn từ database
    }
}
