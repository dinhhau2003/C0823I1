import {useEffect, useState} from "react";
import {useNavigate} from "react-router-dom";
import {Field, Form, Formik} from "formik";
import {toast} from "react-toastify";
import {createProduct} from "../service/productService";

const Create=()=>{
    const [categories,setCategories]=useState();
    const navigate=useNavigate();
    useEffect(() => {

    }, []);
    return(
        <div>
            <Formik
                initialValues={{ name: "", price: "", category: "" }}
                onSubmit={(values) => {
                    const prd = { ...values, category: JSON.parse(values.category) };
                    createProduct(prd).then(() => {
                        toast.success("Product created");
                        navigate("/");
                    });
                }}
            >
                {() => (
                    <Form>
                        <Field type="text" name="name" />
                        <Field type="text" name="price" />
                        <Field as="select" name="category">
                            {categories &&
                                categories.map((category) => (
                                    <option key={category.id} value={JSON.stringify(category)}>
                                        {category.name}
                                    </option>
                                ))}
                        </Field>
                        <button type="submit">Submit</button>
                    </Form>
                )}
            </Formik>
        </div>
    );
};
export default Create;