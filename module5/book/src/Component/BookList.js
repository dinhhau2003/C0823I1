import {useEffect, useState} from "react";
import * as bookService from "../Service/BookService";
import './Css/ProductList.css';
import {NavLink, useNavigate} from "react-router-dom";
import ConfirmDelete from "./confirmDelete";
import {toast} from "react-toastify";
import * as categoryService from "../Service/CategoryService";
function BookList(){
    const [books,setBooks]=useState([]);
    const navigate = useNavigate();
    const [book,setBook]=useState([]);
    const [bookToDelete, setBookToDelete] = useState(null);
    const [showConfirm, setShowConfirm] = useState(false);
    const [bookNameToDelete, setBookNameToDelete] = useState(""); // Thêm state cho tên sản phẩm
    const [categoryList,setCategoryList]=useState([]);
    const [category,setCategory]=useState("");


    useEffect(() => {
        getAll()
        getAllCategories()
    }, []);
    const getAllCategories=async ()=>{
        const categories=await categoryService.getAllCategory();
        setCategoryList(categories);
    }
    const getAll=async (name,category)=>{
        const books=await bookService.getAllBook(name,category);
        setBooks(books);
    }
    const handleUpdate = (selectedBook) => {
        setBook(selectedBook);
        navigate("/books/updateBook", {state: {book: selectedBook}});
    };

    const confirmDeleteBook = (book) => {
        setBookToDelete(book.id);
        setBookNameToDelete(book.title); // Lưu tên sản phẩm
        setShowConfirm(true);
    };
    const handleDeleteBook = async (id) => {
        const success = await bookService.deleteBook(id);
        if (success){
            setBooks(books.filter(book => book.id !== id));
            toast.success("Xóa thành công")
        } else {
            toast.error("Xóa thất bại")
        }
    };
    const deleteConfirmedBook = async () => {
        if (bookToDelete) {
            await handleDeleteBook(bookToDelete);
            setShowConfirm(false);
            setBookToDelete(null);
            setBookNameToDelete(""); // Reset tên sản phẩm
        }
    };
    const cancelDelete = () => {
        setShowConfirm(false);
        setBookToDelete(null);
        setBookNameToDelete(""); // Reset tên sản phẩm
    };
    const handleSearchSubmit = async (event) => {
        event.preventDefault();
        let allBooks;
        if (category === "" || category === " ") {  // Kiểm tra nếu không có category
            allBooks = await bookService.getAllBook(name);
        } else {
            allBooks = await bookService.getAllBook(name, category);  // Truyền category ID
        }
        setBooks(allBooks);
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
                    <th>Title</th>
                    <th>Amount</th>
                    <th>publicationDate</th>
                    <th>Category</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                {
                    books.map((book)=>
                        <tr key={book.id}>
                            <td>{book.title}</td>
                            <td>{book.amount}</td>
                            <td>{book.publicationDate}</td>
                            <td>{book.category.name}</td>
                            <td>
                                <button onClick={()=>handleUpdate(book)}>
                                    <NavLink to="/books/UpdateBook">Cập nhập</NavLink>
                                </button>
                                <button onClick={()=> confirmDeleteBook(book)}>Xóa</button>

                            </td>
                        </tr>
                    )
                }
                </tbody>
            </table>
            {showConfirm && (
                <ConfirmDelete
                    bookName={bookNameToDelete} // Truyền tên sản phẩm vào modal
                    onConfirm={deleteConfirmedBook}
                    onCancel={cancelDelete}
                />
            )}
        </div>
    )
}
export default BookList;