import {useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";
import * as employeeService from "../Service/EmployeeService";
function CreateEmployee(){
    const navigate=useNavigate();
    const employee={
        // id:"",
        firstName:"",
        lastName:"",
        email:"",
    }

    const saveEmployee=async (value)=>{
        await employeeService.saveEmployee(value);
        toast.success("Thêm mới thành công");
        navigate("/employee")
    }
    const handleBack=(navigate)=>{
        navigate("/employee");
    }
    return(
        <div className="update-book-container">
            <Formik initialValues={employee} onSubmit={saveEmployee}>
                <Form>
                    <h1>Thêm mới Sản Phẩm</h1>
                    <div>
                        <label>Title</label>
                        <Field name="firstName"></Field>
                        <ErrorMessage name="firstName" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Price</label>
                        <Field name="lastName"></Field><br></br>
                        <ErrorMessage name="lastName" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Date</label>
                        <Field name="email" component="input" ></Field><br></br>
                        <ErrorMessage name="email" component="span"></ErrorMessage> <br></br>
                    </div>

                    <div>
                        <button type="submit">Thêm mới</button>
                    </div>
                    <div>
                        <button type="button" onClick={() => handleBack(navigate)}>Trở về</button>
                    </div>
                </Form>
            </Formik>
        </div>
    )
}
export default CreateEmployee;