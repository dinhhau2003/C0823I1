package com.example.websocket.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "shipping_day")
    private LocalDateTime shippingDay;

    @Column(name = "status")
    private String status;

    @Column(name = "total_money_order")
    private double totalMoneyOrder;

    @ManyToOne
    @JoinColumn(name = "call_request_id", nullable = false)
    private CallRequestMessage callRequestMessage;
}