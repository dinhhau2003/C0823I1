import {ErrorMessage, Field, Form, Formik} from "formik";
import {useState} from "react";
import * as yup from "yup";
import {toast} from "react-toastify";
import {useNavigate} from "react-router-dom";
import * as studentService from "../../service/StudentService"
import {useDispatch} from "react-redux";
import {addStudentByMiddleware} from "../../redux/middleware/StudentMiddleware";

function StudentCreate() {
    const [student, setStudent] = useState({
        id: "",
        name: "",
        address: "",
        point: ""
    })

    const navigate = useNavigate();
    const dispatch = useDispatch();

    const validStudent = {
        name: yup.string().required("Name không được để trống")
            .min("3", "Name không được nhỏ hơn 3 ký tự")
            .max("150", "Name không được dài hơn 150 ký tự")
            .matches(/^[A-Za-z ]{3,150}$/, "Name không đúng định dạng. Tên chỉ chứa ký tự và dấu cách, độ dài từ 3 đến 150 ký tự")
    }

    const saveStudent = async (value) => {
        value.point = +value.point;
        dispatch(addStudentByMiddleware(value))
        toast.success("Thêm mới thành công")
        navigate("/student")
    }

    return (
        <>
            <Formik initialValues={student} onSubmit={saveStudent} validationSchema={yup.object(validStudent)}>
                <Form>
                    Name: <Field name="name"/>
                    <ErrorMessage name="name" component="p"></ErrorMessage>
                    Address: <Field name="address"/>
                    Point: <Field name="point"/>
                    <button type="submit">Thêm mới</button>
                </Form>
            </Formik>
        </>
    )
}

export default StudentCreate;