// App.js
import './App.css';
import { BrowserRouter, Route, Routes } from "react-router-dom";
import { Layout } from "./component/Layout";
import { List } from "./component/List";
import {ToastContainer} from "react-toastify"; // Đảm bảo import đúng List
import 'bootstrap/dist/css/bootstrap.min.css';
import Create from "./component/Create";

function App() {
    return (
            <Routes>
                <Route path="/" element={<Layout />}>
                    <Route index element={<List />} />
                    <Route path="/create" element={<Create />} />
                    {/*<Route path="/update/:id" element={<Update />} />*/}
                </Route>
            </Routes>
    );
}

export default App;
