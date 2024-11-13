import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from "react-router-dom";
import { toast } from "react-toastify";
import * as employeeService from "../Service/EmployeeService";
import { ErrorMessage, Field, Form, Formik } from "formik";

function UpdateEmployee() {
    const { id } = useParams(); // Lấy ID từ URL
    const navigate = useNavigate();

    const [employee, setEmployee] = useState({
        firstName: "",
        lastName: "",
        email: "",
    });

    // Hàm lấy thông tin nhân viên để hiển thị
    const fetchEmployee = async () => {
        const response = await employeeService.getEmployeeById(id);
        console.log(response)
        if (response) {
            setEmployee(response);
        } else {
            toast.error("Không tìm thấy nhân viên");
            navigate("/employee"); // Quay lại danh sách nếu không tìm thấy
        }
    };

    useEffect(() => {
        fetchEmployee();
    }, [id]);

    const saveEmployee = async (values) => {
        const response = await employeeService.updateEmployee(id, values);
        if (response) {
            toast.success("Cập nhật thành công");
            navigate("/employee");
        } else {
            toast.error("Cập nhật thất bại");
        }
    };

    return (
        <div className="update-employee-container">
            <Formik
                initialValues={employee}
                enableReinitialize
                onSubmit={saveEmployee}
            >
                <Form>
                    <h1>Cập nhật Nhân Viên</h1>
                    <div>
                        <label>First Name</label>
                        <Field name="firstName" />
                        <ErrorMessage name="firstName" component="span" />
                    </div>
                    <div>
                        <label>Last Name</label>
                        <Field name="lastName" />
                        <ErrorMessage name="lastName" component="span" />
                    </div>
                    <div>
                        <label>Email</label>
                        <Field name="email" type="email" />
                        <ErrorMessage name="email" component="span" />
                    </div>
                    <div>
                        <button type="submit">Cập nhật</button>
                    </div>
                    <div>
                        <button type="button" onClick={() => navigate("/employee")}>
                            Trở về
                        </button>
                    </div>
                </Form>
            </Formik>
        </div>
    );
}

export default UpdateEmployee;
