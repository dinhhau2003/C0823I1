import {useEffect, useState} from "react";
import {Link} from "react-router-dom";
import * as studentService from "../../Service/StudentService";

function StudentListFunc() {
    const [students, setStudents] = useState()

    useEffect(() => {
        getStudents();
    },[]);
    const getStudents = async () => {
        let temp = await studentService.getAllStudents()
        setStudents(temp)
    }

    if (!students) return <div>Loading...</div>

    return (
        <div>
            <Link to="/create">Thêm mới</Link>
            <h1>Danh sách học sinh</h1>
            <table>
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Adress</th>
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
        </div>
    )
}

export default StudentListFunc;