// src/components/TableList.js
import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';
import { getAllTables } from '../service/TableService';

const TableList = () => {
    const [tables, setTables] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
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

        fetchTables();
    }, []);

    if (loading) return <p>Loading...</p>;

    return (
        <div>
            <h2>Danh Sách Tên Bàn</h2>
            <ul>
                {tables.map((table) => (
                    <li key={table.tableId}>
                        <Link to={`/tables/${table.tableId}`}>{table.tableName}</Link>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default TableList;
