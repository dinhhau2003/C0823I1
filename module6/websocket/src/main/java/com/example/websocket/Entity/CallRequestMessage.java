package com.example.websocket.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CallRequestMessage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "table_id", nullable = false)
    private Long tableId;

    @Column(name = "user_id", nullable = false)
    private Long userId;
    private String tableName;        // Tên bàn
    private LocalDateTime callTime;   // Thời gian gọi

    @OneToMany(mappedBy = "callRequestMessage", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

}
