import {useEffect, useState} from "react";
import * as productService from "../Service/ProductService";
import './Css/ProductList.css';
import * as categoryService from "../Service/CategoryService";

function ProductList({resetList, setResetList}) {
    const [products, setProducts] = useState([]);
    const [categoryList,setCategoryList]=useState([]);
    const [category,setCategory]=useState("");
    const [name,setName]=useState("");


    useEffect(() => {
        if (resetList) {
            getAll();
            setResetList(false);
        }
    }, [resetList, setResetList]);
    useEffect(() => {
        getAll();
        getAllCategories()
    }, []);
    const getAllCategories=async ()=>{
        const categories=await categoryService.getAllCategory();
        setCategoryList(categories);
    }
    const getAll = async (name, category) => {
        const products = await productService.getAllProduct(name, category);
        setProducts(products);
    }
    const handleChange = (event) => {
        const selectedValue = event.target.value;

        if (selectedValue !== " ") {
            try {
                const selectedCategory = JSON.parse(selectedValue);
                setCategory(selectedCategory.id);
            } catch (error) {
                console.error("Error parsing JSON:", error);
            }
        } else {
            setCategory("");
        }
    };
    const handleSearchSubmit = async (event) => {
        event.preventDefault();
        let allProducts;
        if (category === "" || category === " ") {
            allProducts = await productService.getAllProduct(name);
        } else {
            allProducts = await productService.getAllProduct(name, category);
        }
        setProducts(allProducts);
    };
    return (
        <div>
            <form onSubmit={(e) => handleSearchSubmit(e)}>
                <label>Tiêu đề </label>
                <input
                    type="text"
                    placeholder="Tìm kiếm theo tên sản phẩm..."
                    value={name}
                    onChange={(e) => setName(e.target.value)}
                />
                <br/>


                <br></br> <label>Category </label>
                <select id="category" onChange={handleChange}>
                    <option value=" ">--All Category--</option>
                    {categoryList.map((category) => (
                        <option key={category.id} value={JSON.stringify(category)}>{category.name} </option>
                    ))}
                </select>
                <br></br><br></br>
                <button type="submit">Tìm kiếm</button>
            </form>
            <table>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>Mã sản phẩm</th>
                    <th>Tên Sản phẩm</th>
                    <th>Thể loại</th>
                    <th>Số lượng</th>
                    <th>Mô tả</th>
                    <th>Giá</th>
                    <th>Ngày Nhập</th>
                </tr>
                </thead>
                <tbody>
                {
                    products.map((product, index) =>
                        <tr key={product.id}>
                            <td>{index + 1}</td>
                            <td>{product.id}</td>
                            <td>{product.name}</td>
                            <td>{product.category.name}</td>
                            <td>{product.soLuong}</td>
                            <td>{product.moTa}</td>
                            <td>{product.price}</td>
                            <td>{product.date}</td>
                        </tr>
                    )
                }
                </tbody>
            </table>
        </div>
    )
}

export default ProductList;
