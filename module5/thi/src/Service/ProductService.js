import axios from "axios";

export const getAllProduct=async (name,category)=>{
    try {
        let query="http://localhost:8080/products?";
        if (name){
            query +=`name_like=${name}&`;
        }
        if (category){
            query +=`category.id=${category}&`;
        }
        let result =await axios.get(query);
        return result.data
    }catch (e) {
        console.log(e)
    }
}
export const saveProduct=async (product)=>{
    try {
        await axios.post("http://localhost:8080/products",product);
        return true;
    }catch (e) {
        return false
    }
}