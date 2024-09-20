import {useEffect, useState} from "react";
import * as productService from "../service/ProductService";
import './Css/ProductList.css'
import {NavLink, useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import ConfirmDelete from "./confirmDelete";
import * as categoryService from "../service/CategoryService";
function ProductList({resetList, setResetList}){
    const [product,setProduct]=useState([]);
    const [products,setProducts]=useState([]);
    const navigate = useNavigate();
    const [productToDelete, setProductToDelete] = useState(null);
    const [showConfirm, setShowConfirm] = useState(false);
    const [productNameToDelete, setProductNameToDelete] = useState(""); // Thêm state cho tên sản phẩm
    const [categoryList,setCategoryList]=useState([]);
    const [category,setCategory]=useState("");
    const [name,setName]=useState("");

    useEffect(() => {
        if (resetList) {
            getAll();  // Khi resetList thay đổi, reset danh sách về ban đầu
            setResetList(false); // Đặt lại resetList để tránh gọi lại không cần thiết
        }
    }, [resetList, setResetList]);

    useEffect(() => {
        getAll();
        getAllCategories();
    }, []);
    const getAllCategories=async ()=>{
        const categories=await categoryService.getAllCategory();
        setCategoryList(categories);
    }
    const getAll=async (name,category)=>{
        const products=await productService.getAllProduct(name,category);
        setProducts(products);
    }
    const handleUpdate = (selectedProduct) => {
        setProduct(selectedProduct);
        navigate("/products/UpdateProducts", {state: {product: selectedProduct}});
    };
    const confirmDeleteProduct = (product) => {
        setProductToDelete(product.id);
        setProductNameToDelete(product.name); // Lưu tên sản phẩm
        setShowConfirm(true);
    };
    const cancelDelete = () => {
        setShowConfirm(false);
        setProductToDelete(null);
        setProductNameToDelete(""); // Reset tên sản phẩm
    };
    const handleDeleteProduct = async (id) => {
        const success = await productService.deleteProduct(id);
        if (success){
            setProducts(products.filter(clothe => clothe.id !== id));
            toast.success("Xóa thành công")
        } else {
            toast.error("Xóa thất bại")
        }
    };
    const deleteConfirmedProduct = async () => {
        if (productToDelete) {
            await handleDeleteProduct(productToDelete);
            setShowConfirm(false);
            setProductToDelete(null);
            setProductNameToDelete(""); // Reset tên sản phẩm
        }
    };

    const handleSearchSubmit = async (event) => {
        event.preventDefault();
        let allProducts;
        if (category === "" || category === " ") {  // Kiểm tra nếu không có category
            allProducts = await productService.getAllProduct(name);
        } else {
            allProducts = await productService.getAllProduct(name, category);  // Truyền category ID
        }
        setProducts(allProducts);
    };
    const handleChange = (event) => {
        const selectedValue = event.target.value;

        if (selectedValue !== " ") {
            try {
                const selectedCategory = JSON.parse(selectedValue);
                setCategory(selectedCategory.id); // Lưu ID thay vì toàn bộ đối tượng
            } catch (error) {
                console.error("Error parsing JSON:", error);
            }
        } else {
            setCategory(""); // Đặt lại về chuỗi trống nếu không có category
        }
    };
    return(
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
                    <th>Tên sản phẩm</th>
                    <th>Giá</th>
                    <th>Ngày</th>
                    <th>Category</th>
                    <th>Tác vụ</th>
                </tr>
                </thead>
                <tbody>
                {
                    products.map((product)=>
                        <tr key={product.id}>
                            <td>{product.name}</td>
                            <td>{product.price}</td>
                            <td>{product.date}</td>
                            <td>{product.category.name}</td>
                            <td>
                                <button onClick={()=>handleUpdate(product)}>
                                    <NavLink to="/products/UpdateProducts">Cập nhập</NavLink>
                                </button>
                                <button onClick={()=> confirmDeleteProduct(product)}>Xóa</button>
                            </td>
                        </tr>
                    )
                }
                </tbody>
            </table>
            {showConfirm && (
                <ConfirmDelete
                    productName={productNameToDelete} // Truyền tên sản phẩm vào modal
                    onConfirm={deleteConfirmedProduct}
                    onCancel={cancelDelete}
                />
            )}
        </div>
    )
}
export default ProductList;