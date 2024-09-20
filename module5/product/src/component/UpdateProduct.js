import {useLocation, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as categoryService from "../service/CategoryService";
import * as productService from "../service/ProductService";
import {toast} from "react-toastify";
import * as yup from "yup";
import {ErrorMessage, Field, Form, Formik} from "formik";

const UpdateProduct=()=>{
    const location=useLocation();
    const navigate = useNavigate();
    const [category, setCategory] = useState([]);
    const product = location.state?.product;
    useEffect(() => {
        getAllCategories()
    }, [])
    const getAllCategories = async () => {
        const categories = await categoryService.getAllCategory();
        setCategory(categories);
    }
    const saveProduct=async (value)=>{
        value.category=JSON.parse(value.category)
        await productService.updateProduct(value.id,value);
        toast.success("cập nhập thành công");
        navigate("/products");
    }
    const validateProduct={
        name:yup.string().required("please enter name")
            .min(0,"please enter a name more than 0")
            .typeError("please enter only string"),
    }
    const handleBack=(navigate)=>{
        navigate("/products");
    }

    return (
        <div className="update-book-container">
            <h1>Cập nhật clothes</h1>
            <Formik
                initialValues={{
                    id: product.id,
                    name: product.name,
                    price: product.price,
                    date: product.date,
                    category: JSON.stringify(product.category)
                }}
                onSubmit={saveProduct}
                validationSchema={yup.object(validateProduct)}>
                <Form>
                    <div>
                        <label>ID:</label>
                        <Field name="id"></Field>
                        <ErrorMessage name="id" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Name</label>
                        <Field name="name"></Field>
                        <ErrorMessage name="name" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Price</label>
                        <Field name="price"></Field><br></br>
                        <ErrorMessage name="price" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Date</label>
                        <Field name="date" component="input" type="date"></Field><br></br>
                        <ErrorMessage name="date" component="span"></ErrorMessage> <br></br>
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
export default UpdateProduct;