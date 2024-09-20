import {BrowserRouter, NavLink, Route, Routes, useNavigate} from "react-router-dom";
import ClothesList from "./Component/ClothesList";
import CreateClothes from "./Component/CreateClothes";
import {ToastContainer} from "react-toastify";
import UpdateClothes from "./Component/UpdateClothes";
import {useState} from "react";
import './App.css';

function App() {
    const [resetList, setResetList] = useState(false);

    const handleResetList = () => {
        setResetList(true);
    };

    return (
        <div>
                <div className="nav-link-buttons">
                    <NavLink
                        to="/clothes"
                        onClick={handleResetList} // Khi nhấn, gọi hàm reset
                    >
                        Danh Sản Phẩm
                    </NavLink>
                    <NavLink to="/clothes/create">Thêm Mới Sản Phẩm</NavLink>
                </div>
                <Routes>
                    <Route path="/clothes" element={<ClothesList resetList={resetList} setResetList={setResetList} />}></Route>
                    <Route path="/clothes/create" element={<CreateClothes />}></Route>
                    <Route path="/clothes/UpdateClothes" element={<UpdateClothes />}></Route>
                </Routes>
            <ToastContainer></ToastContainer>
        </div>
    );
}

export default App;
