import { BrowserRouter as Router, Routes, Route, NavLink } from "react-router-dom";
import AppBar from "./Component/Appbar";
import Employee from "./Component/Employee";
import CreateEmployee from "./Component/CreateEmployee";
import UpdateEmployee from "./Component/UpdateEmployee";
import {ToastContainer} from "react-toastify"; // Import component
import 'react-toastify/dist/ReactToastify.css';


function App() {
    return (
        <div className="App">
            <AppBar />
            <nav>
                <NavLink to="/employee">Employee List</NavLink>
                <NavLink to="/employee/add">Thêm Nhân Viên</NavLink>
            </nav>
            <Routes>
                <Route path="/employee" element={<Employee />} />
                <Route path="/employee/add" element={<CreateEmployee />} />
                <Route path="/employee/update/:id" element={<UpdateEmployee />} /> {/* Route cho update */}
            </Routes>
            <ToastContainer></ToastContainer>
        </div>
    );
}

export default App;
