package com.example.websocket.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "table_info") // Đổi tên bảng để tránh trùng với từ khóa SQL
public class TableInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tableId;

    @Column(name = "table_code", nullable = false)
    private String tableCode;

    @Column(name = "status")
    private String status;

    @Column(name = "table_name")
    private String tableName;
}