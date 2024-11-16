import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getAllTables } from '../service/TableService';

const TableListAdmin = () => {
    const [tables, setTables] = useState([]);
    const [loading, setLoading] = useState(true);
    const [paidTables, setPaidTables] = useState([]); // State để lưu bàn đã thanh toán

    useEffect(() => {
        // Hàm fetch dữ liệu bàn
        const fetchTables = async () => {
            try {
                const data = await getAllTables();
                setTables(data);
            } catch (error) {
                console.error("Error fetching table data:", error);
            } finally {
                setLoading(false);
            }
        };

        // Fetch các bàn từ server
        fetchTables();

        // Hàm cập nhật trạng thái từ localStorage
        const updatePaidTablesFromLocalStorage = () => {
            const paidTableIds = JSON.parse(localStorage.getItem('paidTables')) || [];
            setPaidTables(paidTableIds);
        };

        // Cập nhật paidTables từ localStorage khi component mount
        updatePaidTablesFromLocalStorage();

        // Lắng nghe sự thay đổi của localStorage (chỉ áp dụng với window)
        window.addEventListener('storage', updatePaidTablesFromLocalStorage);

        // Dọn dẹp listener khi component unmount
        return () => {
            window.removeEventListener('storage', updatePaidTablesFromLocalStorage);
        };
    }, []);

    const handlePaidStatus = (tableId) => {
        // Thêm hoặc xóa bàn khỏi danh sách đã thanh toán
        const updatedPaidTables = paidTables.includes(tableId)
            ? paidTables.filter(id => id !== tableId)
            : [...paidTables, tableId];

        setPaidTables(updatedPaidTables);

        // Cập nhật localStorage để giữ trạng thái khi chuyển sang trang khác
        localStorage.setItem('paidTables', JSON.stringify(updatedPaidTables));
    };

    if (loading) return <p>Loading...</p>;

    return (
        <div>
            <h2>Danh Sách Tên Bàn</h2>
            <ul>
                {tables.map((table) => (
                    <li
                        key={table.tableId}
                        style={{
                            backgroundColor: paidTables.includes(table.tableId) ? 'lightgreen' : 'white',
                            padding: '10px',
                            margin: '5px 0',
                            borderRadius: '5px',
                        }}
                    >
                        <Link
                            to={`/tables/${table.tableId}`}
                            onClick={() => handlePaidStatus(table.tableId)} // Cập nhật trạng thái khi click vào bàn
                        >
                            {table.tableName}
                        </Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TableListAdmin;
