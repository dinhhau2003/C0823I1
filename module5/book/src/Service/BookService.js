import axios from "axios";

export const getAllBook=async (name,category)=>{
    try {
        let query="http://localhost:8080/books?";
        if (name){
            query +=`name_like=${name}&`;
        }
        if (category){
            query +=`category.id=${category}&`;
        }
        let result =await axios.get(query);
        return result.data
    }catch (e){
        console.log(e)
    }
}
export const saveBook=async (book)=>{
    try {
        await axios.post("http://localhost:8080/books",book);
        return true;
    }catch (e) {
        return false
    }
}
export const updateBook = async (id, updateBook) => {
    try {
        await axios.patch(`http://localhost:8080/books/${id}`, updateBook);
        return true;
    } catch (err) {
        return false;
    }
}
export const deleteBook = async (id) => {
    try {
        await axios.delete(`http://localhost:8080/books/${id}`);
        return true;
    } catch (err) {
        return false;
    }
}