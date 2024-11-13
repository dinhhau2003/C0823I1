import React, { useEffect, useState } from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';  // Sử dụng Routes thay cho Switch
import SelectTablePage from './component/SelectTablePage';  // Trang chọn bàn
import ClientPage from './component/ClientPage';  // Trang client
import admin from './component/AdminPage';
import AdminPage from "./component/AdminPage";  // Trang client

const App = () => {
    return (
        <Router>
            <Routes>
                <Route path="/select-table" element={<SelectTablePage />} />  {/* Sử dụng element thay cho component */}
                <Route path="/client/:tableId" element={<ClientPage />} />
                <Route path="/admin" element={<AdminPage />} />
                {/* Bạn có thể thêm các Route khác ở đây */}
            </Routes>
        </Router>
    );
};

export default App;
