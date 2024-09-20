import './App.css';
import React from "react";
import 'react-toastify/dist/ReactToastify.css';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import {ToastContainer} from "react-toastify";
import ListBook from "./Component/book/BookList";
import CreateBook from "./Component/book/CreateBook";
import UpdateBook from "./Component/book/UpdateBook";

function App() {
  return (
  <div>
    <BrowserRouter>
      <div className="nav-link-buttons">
        <NavLink to="/books">Danh sách</NavLink>
        <NavLink to="/books/CreateBook">Thêm mới</NavLink>
      </div>
      <Routes>
        <Route path="/books" element={<ListBook/>}></Route>
        <Route path="/books/CreateBook" element={<CreateBook/>}></Route>
        <Route path="/books/UpdateBook" element={<UpdateBook/>}></Route>
      </Routes>
    </BrowserRouter>
    <ToastContainer></ToastContainer>
  </div>
  );
}

export default App;
