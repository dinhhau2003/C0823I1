import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';  // Sử dụng useNavigate thay cho useHistory

const SelectTablePage = () => {
    const [tables, setTables] = useState([]);
    const navigate = useNavigate();  // Khởi tạo useNavigate để điều hướng

    useEffect(() => {
        // Lấy thông tin bàn từ API khi component load
        axios.get('http://localhost:8080/api/tables')
            .then(response => {
                setTables(response.data);  // Lưu dữ liệu bàn vào state
            })
            .catch(error => {
                console.error('Error fetching tables:', error);
            });
    }, []);

    // Xử lý khi người dùng chọn bàn
    const handleTableSelect = (tableId) => {
        navigate(`/client/${tableId}`);  // Điều hướng sang trang ClientPage với tableId trong URL
    };

    return (
        <div>
            <h1>Chọn Bàn</h1>
            {/* Hiển thị danh sách bàn */}
            <ul>
                {tables.map((table) => (
                    <li key={table.tableId}>
                        <button onClick={() => handleTableSelect(table.tableId)}>
                            {table.tableName} - Mã bàn: {table.tableCode}
                        </button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default SelectTablePage;
