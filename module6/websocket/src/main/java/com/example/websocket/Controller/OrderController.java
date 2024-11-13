package com.example.websocket.Controller;
import com.example.websocket.Entity.OrderDetail;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {

    @MessageMapping("/order")
    @SendTo("/topic/orders")
    public OrderDetail handleOrder(OrderDetail orderDetail) {
        // Lưu order vào cơ sở dữ liệu nếu cần (có thể dùng repository để lưu)
        System.out.println("Received new order from table: " + orderDetail.getCallRequestMessage().getTableId());
        return orderDetail; // Gửi lại order để các admin nhận được qua WebSocket
    }
}
