import {useEffect, useState} from "react";
import './Css/BookList.css'
import * as bookService from "../../Service/BookService";
import * as categoryService from "../../Service/CategoryService";
import {NavLink, useNavigate} from "react-router-dom";
import ConfirmDelete from "./confirmDeleteBook";
import {toast} from "react-toastify";

function ListBook() {
    const [books, setBooks] = useState([]);

    // update
    const [book, setBook] = useState([]);
    const navigate = useNavigate();

    const [searchTerm, setSearchTerm] = useState("");
    const [showConfirm, setShowConfirm] = useState(false);
    const [bookToDelete, setBookToDelete] = useState(null);
    const [publicationDate, setPublicationDate] = useState("");
    const [endDate, setEndDate] = useState("");
    const [category, setCategory] = useState("");
    const [categoryList, setCategoryList] = useState([]);

    useEffect(() => {
        getAll(searchTerm, publicationDate, endDate, category)
        getAllCategories()
    }, [])

    const getAll = async (title, publicationDate, endDate, category) => {
        const books = await bookService.getAllBooks(title, publicationDate, endDate, category);
        setBooks(books);
    };
    const getAllCategories = async () => {
        const categories = await categoryService.getAllCategory();
        setCategoryList(categories);
    }
    const handleSearchSubmit = async (event) => {
        event.preventDefault();
        let allBooks;
        if (category === " ") {
            allBooks = await bookService.getAllBooks(searchTerm, publicationDate, endDate);
        } else {
            allBooks = await bookService.getAllBooks(searchTerm, publicationDate, endDate, category);
        }
        setBooks(allBooks);
    };

    const handleChange = (event) => {
        const selectedValue = event.target.value;

        if (selectedValue !== " ") {
            try {
                const selectedCategory = JSON.parse(selectedValue);
                setCategory(selectedCategory);
            } catch (error) {
                console.error("Error parsing JSON:", error);
            }
        } else {
            setCategory(" ");
        }
    };


    const handleUpdate = (selectedBook) => {
        setBook(selectedBook);
        navigate("/books/UpdateBook", {state: {book: selectedBook}});
    };


    const deleteConfirmedBook = async () => {
        if (bookToDelete) {
            await handleDeleteBook(bookToDelete);
            setShowConfirm(false);
            setBookToDelete(null);
        }
    };
    const cancelDelete = () => {
        setShowConfirm(false);
        setBookToDelete(null);
    };
    const handleDeleteBook = async (id) => {
        const success = await bookService.deleteBook(id);
        if (success) {
            setBooks(books.filter(book => book.id !== id));
            toast.success("Xóa thành công")
        } else {
            toast.error("Xóa thất bại")
        }
    };
    const confirmDeleteBook = (id) => {
        setBookToDelete(id);
        setShowConfirm(true);
    };
    return (
        <div>
            <h1>List Of Books</h1>
            <form onSubmit={(e) => handleSearchSubmit(e)}>
                <label>Tiêu đề </label>
                <input
                    type="text"
                    placeholder="Tìm kiếm sách..."
                    value={searchTerm}
                    onChange={(e) => setSearchTerm(e.target.value)}
                />
                <br></br> <label>Ngày bắt đầu </label>
                <input
                    type="date"
                    value={publicationDate}
                    onChange={(e) => setPublicationDate(e.target.value)}
                />
                <br></br> <label>Ngày kết thúc </label>
                <input
                    type="date"
                    value={endDate}
                    onChange={e => setEndDate(e.target.value)}
                />
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
                    <th>Tiêu đề</th>
                    <th>Số lượng</th>
                    <th>Ngày xuất bản</th>
                    <th>Thể loại</th>
                    <th>Tác vụ</th>
                </tr>
                </thead>
                <tbody>
                {
                    books.map((book) =>
                        <tr key={book.id}>
                            <td>{book.title}</td>
                            <td>{book.amount}</td>
                            <td>{book.publicationDate}</td>
                            <td>{book.category.name}</td>
                            <td>
                                <button onClick={() => handleUpdate(book)}>
                                    <NavLink to="/books/UpdateBook">Cập nhật</NavLink>
                                </button>
                                <button onClick={() => confirmDeleteBook(book.id)}>Xóa</button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
            {showConfirm && (
                <ConfirmDelete
                    onConfirm={deleteConfirmedBook}
                    onCancel={cancelDelete}
                />
            )}
        </div>
    )
}

export default ListBook;