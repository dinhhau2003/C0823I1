import logo from './logo.svg';
import './App.css';
import {NavLink, Route, Routes} from "react-router-dom";
import ProductList from "./component/ProductList";
import CreateProduct from "./component/CreateProduct";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import UpdateProduct from "./component/UpdateProduct";
import {useState} from "react";


function App() {
    const [resetList, setResetList] = useState(false);
    const handleResetList = () => {
        setResetList(true);
    };
  return (
    <div>
      <div className="nav-link-buttons">
        <NavLink
            to="/products"
            onClick={handleResetList}
        >Danh sách sản phẩm</NavLink>
        <NavLink to="/products/createProduct">Thêm mới sản phẩm</NavLink>
      </div>
      <Routes>
        <Route path="/products" element={<ProductList resetList={resetList} setResetList={setResetList}/>}></Route>
        <Route path="/products/createProduct" element={<CreateProduct/>}></Route>
        <Route path="/products/UpdateProducts" element={<UpdateProduct/>}></Route>
      </Routes>
        <ToastContainer></ToastContainer>
    </div>

  );
}

export default App;
