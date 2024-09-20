import {useEffect, useState} from "react";
import * as clothesService from "../Service/ClothesService"
import * as categoryService from "../Service/CategoryService"
import './Css/ProductList.css'
import {NavLink, useLocation, useNavigate} from "react-router-dom";
import {toast} from "react-toastify";
import ConfirmDelete from "./confirmDelete";
function ClothesList({resetList, setResetList}){
    const [clothes,setClothes]=useState([]);
    const [categoryList,setCategoryList]=useState([]);
    const [name,setName]=useState("");
    const [category,setCategory]=useState("");
    const [clothe,setClothe]=useState([]);
    const navigate = useNavigate();
    const [clotheToDelete, setClotheToDelete] = useState(null);
    const [showConfirm, setShowConfirm] = useState(false);
    const [clotheNameToDelete, setClotheNameToDelete] = useState(""); // Thêm state cho tên sản phẩm
    useEffect(() => {
        if (resetList) {
            getAll();  // Khi resetList thay đổi, reset danh sách về ban đầu
            setResetList(false); // Đặt lại resetList để tránh gọi lại không cần thiết
        }
    }, [resetList, setResetList]);


    useEffect(() => {
        getAll()
        getAllCategories()
    }, []);

    const getAll=async (name,category)=>{
        const clothes=await clothesService.getAllClothes(name,category);
        setClothes(clothes);
        // console.log(clothes)
    }
    const getAllCategories=async ()=>{
        const categories=await categoryService.getAllCategory();
        setCategoryList(categories);
    }
    const handleUpdate = (selectedClothe) => {
        setClothe(selectedClothe);
        navigate("/clothes/UpdateClothes", {state: {clothe: selectedClothe}});
    };


    const confirmDeleteClothe = (clothe) => {
        setClotheToDelete(clothe.id);
        setClotheNameToDelete(clothe.name); // Lưu tên sản phẩm
        setShowConfirm(true);
    };
    const cancelDelete = () => {
        setShowConfirm(false);
        setClotheToDelete(null);
        setClotheNameToDelete(""); // Reset tên sản phẩm
    };
    const handleDeleteClothe = async (id) => {
        const success = await clothesService.deleteClothe(id);
        if (success){
            setClothes(clothes.filter(clothe => clothe.id !== id));
            toast.success("Xóa thành công")
        } else {
            toast.error("Xóa thất bại")
        }
    };
    const deleteConfirmedClothe = async () => {
        if (clotheToDelete) {
            await handleDeleteClothe(clotheToDelete);
            setShowConfirm(false);
            setClotheToDelete(null);
            setClotheNameToDelete(""); // Reset tên sản phẩm
        }
    };
    const handleSearchSubmit = async (event) => {
        event.preventDefault();
        let allClothes;
        if (category === "" || category === " ") {  // Kiểm tra nếu không có category
            allClothes = await clothesService.getAllClothes(name);
        } else {
            allClothes = await clothesService.getAllClothes(name, category);  // Truyền category ID
        }
        setClothes(allClothes);
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
            <h1>List of CLothes</h1>
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
                    <th>Ngày Nhập</th>
                    <th>Số Lượng</th>
                    <th>Loại Sản Phẩm</th>
                    <th>Tác Vụ</th>
                </tr>
                </thead>
                <tbody>
                {
                    clothes.map((clothe)=>
                    <tr key={clothe.id}>
                        <td>{clothe.name}</td>
                        <td>{clothe.date}</td>
                        <td>{clothe.amount}</td>
                        <td>{clothe.category.name}</td>
                        <td>
                            <button onClick={() => handleUpdate(clothe)}>
                                <NavLink to="/clothes/UpdateClothes">Cập nhật</NavLink>
                            </button>
                            <button onClick={() => confirmDeleteClothe(clothe)}>Xóa</button>

                        </td>
                    </tr>
                    )
                }
                </tbody>
            </table>
            {showConfirm && (
                <ConfirmDelete
                    clotheName={clotheNameToDelete} // Truyền tên sản phẩm vào modal
                    onConfirm={deleteConfirmedClothe}
                    onCancel={cancelDelete}
                />
            )}
        </div>
    )
}
export default ClothesList;