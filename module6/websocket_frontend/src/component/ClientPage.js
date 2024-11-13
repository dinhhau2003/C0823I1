import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';  // Lấy tableId từ URL
import { connectWebSocket, callService } from '../service/websocket';

const ClientPage = () => {
    const { tableId } = useParams();  // Lấy tableId từ URL
    const [stompClient, setStompClient] = useState(null);
    const [isConnected, setIsConnected] = useState(false);
    const [selectedTableId, setSelectedTableId] = useState(tableId);  // Gán tableId từ URL vào state

    useEffect(() => {
        const client = connectWebSocket((message) => {
            console.log("Received message:", message);
        });
        setStompClient(client);

        client.onConnect = () => {
            console.log("WebSocket connected!");
            setIsConnected(true);
        };

        client.onDisconnect = () => {
            console.log("WebSocket disconnected.");
            setIsConnected(false);
        };

        return () => {
            if (client) client.deactivate();  // Đóng kết nối khi unmount
        };
    }, []);

    const handleCallService = () => {
        console.log("Selected Table ID:", selectedTableId);
        if (isConnected && stompClient && selectedTableId) {
            const userId = 1;  // ID người dùng mẫu
            callService(stompClient, selectedTableId, userId);  // Gửi dịch vụ qua WebSocket
        } else {
            console.error("WebSocket is not connected or table is not selected.");
        }
    };

    return (
        <div>
            <h1>Trang Client</h1>
            {/* Hiển thị thông tin bàn đã chọn */}
            <p>Bàn đã chọn: {selectedTableId}</p>

            <button onClick={handleCallService}>Gọi phục vụ</button>
        </div>
    );
};

export default ClientPage;
