import logo from './logo.svg';
import './App.css';
import {NavLink, Route, Routes} from "react-router-dom";
import ProductList from "./Component/ProductList";
import CreateProduct from "./Component/CreateProduct";
import 'react-toastify/dist/ReactToastify.css';
import {ToastContainer} from "react-toastify";
import {useState} from "react";


function App() {
    const [resetList, setResetList] = useState(false);
    const handleResetList = () => {
        setResetList(true);
    };
  return (
 <div>
   <div className="nav-link-buttons">
     <NavLink to="/products"
     onClick={handleResetList}>Danh sách sản phẩm</NavLink>
     <NavLink to="/products/createProducts">Thêm Mới</NavLink>
   </div>
   <Routes>
     <Route path="/products" element={<ProductList resetList={resetList} setResetList={setResetList}></ProductList>}></Route>
     <Route path="/products/createProducts" element={<CreateProduct></CreateProduct>}></Route>
   </Routes>
     <ToastContainer></ToastContainer>
 </div>
  );
}

export default App;
