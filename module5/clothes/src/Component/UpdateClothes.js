import {useLocation, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as categoryService from "../Service/CategoryService";
import * as clotheService from "../Service/ClothesService";
import {toast} from "react-toastify";
import * as Yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";

const UpdateClothes=()=>{
    const location=useLocation();
    const navigate = useNavigate();
    const [category, setCategory] = useState([]);
    const clothe = location.state?.clothe;
    useEffect(() => {
        getAllCategories()
    }, [])
    const getAllCategories = async () => {
        const categories = await categoryService.getAllCategory();
        setCategory(categories);
    }
    const saveClothe=async (value)=>{
        value.category=JSON.parse(value.category)
        await clotheService.updateClothe(value.id,value);
        toast.success("Cập Nhập thành công")
        navigate("/clothes")
    }
    const validateClothe={
        name:Yup.string().required("Please enter name")
            .min(0,"Please enter a name more than 0")
            .typeError("Please enter only string"),

    }
    const handleBack=(navigate)=>{
        navigate("/clothes")
    }

    return (
        <div className="update-book-container">
            <h1>Cập nhật clothes</h1>
            <Formik
                initialValues={{
                    id: clothe.id,
                    name: clothe.name,
                    date: clothe.date,
                    amount: clothe.amount,
                    category: JSON.stringify(clothe.category)
                }}
                onSubmit={saveClothe}
                validationSchema={Yup.object(validateClothe)}>
                <Form>
                    <div>
                        <label>ID:</label>
                        <Field name="id"></Field>
                        <ErrorMessage name="id" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Title</label>
                        <Field name="name"></Field>
                        <ErrorMessage name="name" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Date</label>
                        <Field name="date" component="input" type="date"></Field><br></br>
                        <ErrorMessage name="date" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Amount</label>
                        <Field name="amount"></Field><br></br>
                        <ErrorMessage name="amount" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Category</label>
                        <Field as="select" name='category'>
                            <option value="">--Choose category--</option>
                            {category.map(category => (
                                <option key={category.id} value={JSON.stringify(category)}>{category.name}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="category" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <button type="submit">Cập nhật</button>
                    </div>
                    <div>
                        <button type="button" onClick={() => handleBack(navigate)}>Trở về</button>
                    </div>
                </Form>
            </Formik>
        </div>
    );
}
export default UpdateClothes;