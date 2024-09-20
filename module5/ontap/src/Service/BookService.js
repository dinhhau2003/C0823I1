import axios from "axios";

// const URL_STUDENT = "http://localhost:3030/books";

export const getAllBooks = async (title, publicationDate,endDate,category) => {
    try {
        let query = "http://localhost:3030/books?";
        if (title) {
            query += `title_like=${title}&`;
        }
        if (publicationDate) {
            query += `publicationDate_gte=${publicationDate}&`;
        }
        if (endDate){
            query += `publicationDate_lte=${endDate}&`;
        }
        if (category) {
            query += `category.id=${category.id}&`;
        }
        let result = await axios.get(query);
        return result.data;
    } catch (error) {
        console.log(error);
    }
};
export const saveBook = async (book) => {
    try {
        await axios.post("http://localhost:3030/books", book)
        return true;
    } catch (err) {
        return false
    }
}
export const updateBook = async (id, updatedBook) => {
    try {
        await axios.patch(`http://localhost:3030/books/${id}`, updatedBook);
        return true;
    } catch (err) {
        return false;
    }
}
export const deleteBook = async (id) => {
    try {
        await axios.delete(`http://localhost:3030/books/${id}`);
        return true;
    } catch (err) {
        return false;
    }
}
