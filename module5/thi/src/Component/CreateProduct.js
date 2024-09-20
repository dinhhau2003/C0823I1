import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as categoryService from "../Service/CategoryService";
import * as productService from "../Service/ProductService";
import * as Yup from "yup";
import {toast} from "react-toastify";
import {ErrorMessage, Field, Form, Formik} from "formik";
import './Css/ProductForm.css';

function CreateProduct(){
    const navigate = useNavigate();
    const [category, setCategory] = useState([]);
    useEffect(() => {
        getAllCategories()
    }, [])
    const product = {
        id: "",
        name: "",
        category: "",
        soLuong:"",
        moTa:"",
        price:"",
        date: ""
    }
    const getAllCategories = async () => {
        const categories = await categoryService.getAllCategory();
        setCategory(categories);
    }
    const validateProduct = {
        id: Yup.string()
            .required("Vui lòng nhập mã sản phẩm")
            .matches(/^PROD-\d{4}$/, "Mã Product phải đúng định dạng PROD-XXXX (X phải là số)"),
        name: Yup.string()
            .required("Vui lòng nhập tên sản phẩm"),
        category: Yup.string().required("Vui lòng chọn thể loại"),
        soLuong: Yup.number()
            .min(0,"Số lượng phải lớn hơn 0")
            .required("Vui lòng nhập số lượng"),
        moTa: Yup.string().required("Vui lòng nhập mô tả"),
        price: Yup.number()
            .required("Vui lòng nhập giá"),
        date: Yup.date()
            .required("Vui lòng nhập ngày")
            .max(new Date(), "Ngày nhập không được lớn hơn ngày hiện tại"),
    };


    const saveProduct = async (value) => {
        value.category = JSON.parse(value.category)
        await productService.saveProduct(value)
        toast.success("Thêm mới thành công")
        navigate("/products")
    }
    const handleBack = (navigate) => {
        navigate('/products');
    };
    return (
        <div className="update-book-container">
            <Formik initialValues={product} onSubmit={saveProduct} validationSchema={Yup.object(validateProduct)}>
                <Form>
                    <h1>Thêm mới Product</h1>
                    <div>
                        <label>Mã Sản Phẩm:</label>
                        <Field name="id"></Field>
                        <ErrorMessage name="id" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Tên Sản Phẩm</label>
                        <Field name="name"></Field>
                        <ErrorMessage name="name" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Thể Loại</label>
                        <Field as="select" name='category'>
                            <option value="">--Choose category--</option>
                            {category.map(category => (
                                <option key={category.id} value={JSON.stringify(category)}>{category.name}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="category" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Giá</label>
                        <Field name="price"></Field><br></br>
                        <ErrorMessage name="price" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Số Lượng</label>
                        <Field name="soLuong"></Field><br></br>
                        <ErrorMessage name="soLuong" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label> Ngày Nhập </label>
                        <Field name="date" component="input" type="date"/>
                        <ErrorMessage name="date" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Mô tả</label>
                        <Field name="moTa"></Field><br></br>
                        <ErrorMessage name="moTa" component="span"></ErrorMessage> <br></br>
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