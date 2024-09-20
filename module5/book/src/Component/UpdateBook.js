import {useLocation, useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as categoryService from "../Service/CategoryService";
import * as bookService from "../Service/BookService";
import {toast} from "react-toastify";
import * as yup from "yup";
import './Css/ProductForm.css';
import {ErrorMessage, Field, Form, Formik} from "formik";

const UpdateBook=()=>{
    const location=useLocation();
    const navigate = useNavigate();
    const [category, setCategory] = useState([]);
    const book = location.state?.book;
    useEffect(() => {
        getAllCategories()
    }, [])
    const getAllCategories = async () => {
        const categories = await categoryService.getAllCategory();
        setCategory(categories);
    }
    const saveBook=async (value)=>{
        value.category=JSON.parse(value.category)
        await bookService.updateBook(value.id,value);
        toast.success("cập nhập thành công");
        navigate("/books");
    }
    const validateBook={
        title: yup.string()
            .required("Please enter the product name")
            .min(2, "Product name must be at least 2 characters long")  // Tên tối thiểu 2 ký tự
            .max(50, "Product name must be less than 50 characters")     // Tên tối đa 50 ký tự
            .matches(/^[A-Za-z\s]+$/, "Product name can only contain letters and spaces"),  // Chỉ cho phép ký tự chữ và khoảng trắng
        amount: yup.number()
            .required("Please enter the product price")
            .positive("Price must be a positive number")  // Giá phải là số dương
            .integer("Price must be an integer")          // Giá phải là số nguyên
            .min(1, "Price must be at least 1")           // Giá tối thiểu là 1
            .max(1000000, "Price cannot exceed 1,000,000"), // Giá tối đa 1 triệu
        publicationDate: yup.date()
            .required("Please select the product date")
            .max(new Date(), "Date cannot be in the future"), // Ngày không được vượt quá ngày hiện tại
        category: yup.string()
            .required("Please select a category")  // Đảm bảo category được chọn
            .notOneOf([""], "Please select a valid category")  // Không cho phép giá trị rỗng hoặc giá trị mặc định
    }
    const handleBack=(navigate)=>{
        navigate("/books");
    }
    return (
        <div className="update-book-container">
            <h1>Cập nhật Book</h1>
            <Formik
                initialValues={{
                    id: book.id,
                    title: book.title,
                    amount: book.amount,
                    publicationDate: book.publicationDate,
                    category: JSON.stringify(book.category)
                }}
                onSubmit={saveBook}
                validationSchema={yup.object(validateBook)}>
                <Form>
                    <div>
                        <label>ID:</label>
                        <Field name="id"></Field>
                        <ErrorMessage name="id" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Name</label>
                        <Field name="title"></Field>
                        <ErrorMessage name="title" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Price</label>
                        <Field name="amount"></Field><br></br>
                        <ErrorMessage name="amount" component="span"></ErrorMessage> <br></br>
                    </div>
                    <div>
                        <label>Date</label>
                        <Field name="publicationDate" component="input" type="date"></Field><br></br>
                        <ErrorMessage name="publicationDate" component="span"></ErrorMessage> <br></br>
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
export default UpdateBook;