import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

// URL WebSocket backend
const SOCKET_URL = process.env.REACT_APP_SOCKET_URL || 'http://localhost:8080/ws';

export const connectWebSocket = (onMessageReceived) => {
    const socket = new SockJS(SOCKET_URL);
    const stompClient = new Client({
        webSocketFactory: () => socket,
        onConnect: () => {
            console.log("Connected to WebSocket");

            // Đăng ký kênh nhận thông báo cho admin
            stompClient.subscribe('/topic/serviceCall', (message) => {
                try {
                    // Chuyển message.body từ chuỗi JSON thành đối tượng
                    const parsedMessage = JSON.parse(message.body);
                    console.log("Received message:", parsedMessage); // Kiểm tra đối tượng nhận được
                    onMessageReceived(parsedMessage); // Truyền đối tượng đã phân tích cho callback
                } catch (error) {
                    console.error("Error parsing message:", error);
                }
            });
        },
        onStompError: (frame) => {
            console.error("STOMP Error: ", frame);
        }
    });

    stompClient.activate();

    return stompClient;
};


// Hàm để gửi yêu cầu gọi phục vụ
export const callService = (stompClient, tableId, userId) => {
    const payload = JSON.stringify({ tableId, userId });
    console.log("Sending message:", payload);  // Xem nội dung sẽ gửi
    if (stompClient && stompClient.connected) {
        stompClient.publish({
            destination: '/app/callService',
            body: payload,
        });
    } else {
        console.error("WebSocket is not connected.");
    }
};
