
import StudentListFunc from "./components/student/StudentListFunc";
import StudentCreate from "./components/student/StudentCreate";
import {ToastContainer} from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import {BrowserRouter, NavLink, Route, Routes} from "react-router-dom";
import {useDispatch, useSelector} from "react-redux";
import {useEffect} from "react";
import {getALlStudentsByMiddleware} from "./redux/middleware/StudentMiddleware";
function App() {
    const students = useSelector(store => store.students);
    const dispatch=useDispatch();
    useEffect(() => {
        dispatch(getALlStudentsByMiddleware())
    }, []);
    return (
        <div>
            <BrowserRouter>
                <div>
                    <NavLink to="/students">Danh sách</NavLink>
                    <NavLink to="/create">Thêm mới</NavLink>
                    <p>Số lượng học sinh là{students.length}</p>
                </div>
                <Routes>
                    <Route path="/students" element={<StudentListFunc></StudentListFunc>}></Route>
                    <Route path="/create" element={<StudentCreate></StudentCreate>}></Route>
                </Routes>
            </BrowserRouter>
            <ToastContainer></ToastContainer>
        </div>
    );
}

export default App;
