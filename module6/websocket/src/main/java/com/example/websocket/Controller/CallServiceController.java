package com.example.websocket.Controller;

import com.example.websocket.Entity.CallRequestMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;

@Controller
public class CallServiceController {

    private final ObjectMapper objectMapper;

    // Inject ObjectMapper
    public CallServiceController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @MessageMapping("/callService")
    @SendTo("/topic/serviceCall")
    public String callService(CallRequestMessage message) {
        // Giả sử lấy tên bàn từ database hoặc các class liên quan
        message.setTableName("Table " + message.getTableId()); // Tên bàn (tùy chỉnh theo dữ liệu thực tế)
        message.setCallTime(LocalDateTime.now());
        // Sửa đổi trong controller nếu không cần các trường này
        message.setId(null);  // Đảm bảo id là null nếu không sử dụng
        message.setOrderDetails(null);  // Đảm bảo orderDetails là null nếu không cần

        try {
            // Chuyển đối tượng CallRequestMessage thành chuỗi JSON
            String jsonMessage = objectMapper.writeValueAsString(message);
            System.out.println("Sending message: " + jsonMessage);  // In ra chuỗi JSON đã chuyển đổi
            return jsonMessage;
        } catch (Exception e) {
            e.printStackTrace();
            return "{}"; // Trả về chuỗi JSON rỗng nếu có lỗi
        }
    }
}
