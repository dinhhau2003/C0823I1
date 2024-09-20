import axios from "axios";

export const getAllProduct=async (name,category)=>{
    try {
        let query="http://localhost:3030/products?";
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
export const saveProduct=async (product)=>{
    try {
        await axios.post("http://localhost:3030/products",product);
        return true;
    }catch (e) {
        return false
    }
}
export const updateProduct = async (id, updatedProduct) => {
    try {
        await axios.patch(`http://localhost:3030/products/${id}`, updatedProduct);
        return true;
    } catch (err) {
        return false;
    }
}
export const deleteProduct = async (id) => {
    try {
        await axios.delete(`http://localhost:3030/products/${id}`);
        return true;
    } catch (err) {
        return false;
    }
}
