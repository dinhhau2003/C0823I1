// src/App.js
import React from 'react';
import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import TableList from './component/ListTable';
import TableListAdmin from './component/AdminTable';
import TableDetail from "./component/TableDetail";
// import AdminOrderListPage from "./component/AdminOrderListPage";

function App() {
  return (
      <Router>
        <div className="App">

          {/* Cấu hình các Route */}
          <Routes>
            <Route path="/tables" element={<TableList />} />
            <Route path="/admin" element={<TableListAdmin />} />
            <Route path="/tables/:id" element={<TableDetail />} />
              {/*<Route path="/admin/orders/:id" element={<AdminOrderListPage />} />*/}


          </Routes>
        </div>

      </Router>
  );
}

export default App;
