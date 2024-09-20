import {useEffect, useState} from "react";
import {Link, NavLink} from "react-router-dom";
import * as studentService from "../../service/StudentService"
import {useSelector} from "react-redux";

function StudentListFunc() {
    const students = useSelector(state => state.students);
    const [name, setName] = useState("")

    return (
        <>
            <Link to="/create">Thêm mới</Link>
            <input value={name} onChange={(e) => setName(e.target.value)} />

            <h1>Danh sach hoc sinh</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Address</th>
                    <th>Point</th>

                </tr>
                </thead>
                <tbody>
                {
                    students.map((item) => (
                        <tr key={item.id}>
                            <td>{item.id}</td>
                            <td>{item.name}</td>
                            <td>{item.address}</td>
                            <td>{item.point}</td>
                        </tr>
                    ))
                }
                </tbody>
            </table>
        </>
    )
}

export default StudentListFunc;