import logo from './logo.svg';
import './App.css';
import {NavLink, Route, Routes} from "react-router-dom";
import BookList from "./Component/BookList";
import CreateBook from "./Component/CreateBook";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import UpdateBook from "./Component/UpdateBook";


function App() {
  return (
    <div>
      <div className="nav-link-buttons">
        <NavLink to="/books">Danh sách sản phẩm</NavLink>
          <NavLink to="/books/createBook">Thêm mới sản phẩm</NavLink>
      </div>
      <Routes>
        <Route path="/books" element={<BookList></BookList>}></Route>
        <Route path="/books/createBook" element={<CreateBook></CreateBook>}></Route>
        <Route path="/books/updateBook" element={<UpdateBook></UpdateBook>}></Route>
      </Routes>
        <ToastContainer></ToastContainer>
    </div>
  );
}

export default App;
