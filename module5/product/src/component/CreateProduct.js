import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as categoriesService from "../service/CategoryService";
import * as productService from "../service/ProductService";
import * as yup from "yup";
import {toast} from "react-toastify";
import './Css/ProductForm.css';
import {ErrorMessage, Field, Form, Formik} from "formik";

function CreateProduct(){
    const navigate=useNavigate();
    const [category,setCategory]=useState([]);
    useEffect(() => {
        getAllCategories()
    }, []);
    const product={
        id:"",
        name:"",
        price:"",
        date:"",
        category:""
    }
    const getAllCategories=async ()=>{
        const categories=await categoriesService.getAllCategory();
        setCategory(categories)
        }
        const validateProduct={
            name: yup.string()
                .required("Please enter the product name")
                .min(2, "Product name must be at least 2 characters long")  // Tên tối thiểu 2 ký tự
                .max(50, "Product name must be less than 50 characters")     // Tên tối đa 50 ký tự
                .matches(/^[A-Za-z\s]+$/, "Product name can only contain letters and spaces"),  // Chỉ cho phép ký tự chữ và khoảng trắng
            price: yup.number()
                .required("Please enter the product price")
                .positive("Price must be a positive number")  // Giá phải là số dương
                .integer("Price must be an integer")          // Giá phải là số nguyên
                .min(1, "Price must be at least 1")           // Giá tối thiểu là 1
                .max(1000000, "Price cannot exceed 1,000,000"), // Giá tối đa 1 triệu
            date: yup.date()
                .required("Please select the product date")
                .max(new Date(), "Date cannot be in the future"), // Ngày không được vượt quá ngày hiện tại
            category: yup.string()
                .required("Please select a category")  // Đảm bảo category được chọn
                .notOneOf([""], "Please select a valid category")  // Không cho phép giá trị rỗng hoặc giá trị mặc định
        }
    const saveProduct=async (value)=>{
        value.category=JSON.parse(value.category);
        await productService.saveProduct(value);
        toast.success("Thêm mới thành công");
        navigate("/products")
    }
    const handleBack=(navigate)=>{
        navigate("/products");
    }
    return(
        <div className="update-book-container">
            <Formik initialValues={product} onSubmit={saveProduct} validationSchema={yup.object(validateProduct)}>
                <Form>
                    <h1>Thêm mới Sản Phẩm</h1>
                    <div>
                        <label>Title</label>
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
export default CreateProduct;