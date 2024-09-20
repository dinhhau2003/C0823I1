import {useState, useEffect} from "react";
import * as yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import {useDispatch, useSelector} from "react-redux";
import {addStudentByMiddleware1} from "../../redux/middleware/StudentMiddleware";
import * as studentService from "../../Service/StudentService";

function StudentCreate() {
    const [students, setStudents] = useState([]);
    const [student, setStudent] = useState({
        id: "",
        name: "",
        address: "",
        point: ""
    });

    const navigate = useNavigate();
    const dispatch = useDispatch();

    // Lấy danh sách sinh viên từ server hoặc state
    useEffect(() => {
        const fetchStudents = async () => {
            const studentList = await studentService.getAllStudents();
            setStudents(studentList);
        };
        fetchStudents();
    }, []);

    const validStudent = {
        name: yup.string().required("Name không được để trống")
            .min(3, "Name không được nhỏ hơn 3 ký tự")
            .max(150, "Name không được dài hơn 150 ký tự")
            .matches(/^[A-Za-z ]{3,150}$/, "Không đúng định dạng, tên chỉ chứa ký tự và khoảng trắng, độ dài từ 3 đến 150 ký tự"),
        address: yup.string().required("Address không được để trống"),
        point: yup.number().required("Point không được để trống")
            .min(0, "Điểm không được nhỏ hơn 0")
            .max(100, "Điểm không được lớn hơn 100"),
    };

    const saveStudent = (value) => {
        // Tìm id lớn nhất hiện có từ danh sách sinh viên
        const maxId = students.length > 0 ? Math.max(...students.map(s => s.id)) : 0;
        // Gán id mới tự động tăng
        value.id = maxId + 1;
        // Chuyển đổi point thành số
        value.point = +value.point;

        // Gửi dữ liệu thông qua middleware
        dispatch(addStudentByMiddleware1(value));
        toast.success("Thêm mới thành công");
        navigate("/students");
    };

    return (
        <div>
            <Formik initialValues={student} onSubmit={saveStudent} validationSchema={yup.object(validStudent)}>
                <Form>
                    Name:<Field name="name"></Field>
                    <ErrorMessage name="name" component="p"></ErrorMessage>
                    Address:<Field name="address"></Field>
                    <ErrorMessage name="address" component="p"></ErrorMessage>
                    Point:<Field name="point" type="number"></Field>
                    <ErrorMessage name="point" component="p"></ErrorMessage>
                    <button type="submit">Thêm mới</button>
                </Form>
            </Formik>
        </div>
    );
}

export default StudentCreate;
