import {useNavigate} from "react-router-dom";
import {useEffect, useState} from "react";
import * as Yup from "yup";
import * as categoriesService from "../Service/CategoryService";
import * as clotheService from "../Service/ClothesService";
import {toast} from "react-toastify";
import './Css/ProductForm.css';
import {ErrorMessage, Field, Form, Formik} from "formik";
function CreateClothes(){
    const navigate=useNavigate();
    const [category,setCategory]=useState([]);
    useEffect(() => {
        getAllCategories()
    }, []);
    const clothe={
        id:"",
        name:"",
        date:"",
        amount:"",
        category:""
    }
    const getAllCategories=async ()=>{
        const categories=await categoriesService.getAllCategory();
        setCategory(categories)
    }
    const validateClothe={
        name:Yup.string().required("Please enter name")
            .min(0,"Please enter a name more than 0")
            .typeError("Please enter only string"),

    }
    const saveClothe=async (value)=>{
        // value.amount= +value.amount
        const allClothes = await clotheService.getAllClothes();

        // Tìm id lớn nhất hiện tại
        const maxId = allClothes.reduce((max, clothe) => Math.max(max, clothe.id), 0);

        // Gán id mới là maxId + 1
        value.id = maxId + 1;
        value.category=JSON.parse(value.category)
        await clotheService.saveClothe(value);
        toast.success("Thêm mới thành công")
        navigate("/clothes")
    }
    const handleBack=(navigate)=>{
        navigate("/clothes")
    }
    return(
        <div className="update-book-container">
            <Formik initialValues={clothe} onSubmit={saveClothe} validationSchema={Yup.object(validateClothe)}>
                <Form>
                    <h1>Thêm mới Sản Phẩm</h1>
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
export default CreateClothes;