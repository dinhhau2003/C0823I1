import axios from "axios";

export const getProducts=async ()=>{
    const res=await axios.get("http://localhost:8080/products?");
    return res.data;
}
export const createProduct = async (product) => {
    await axios.post("http://localhost:8080/products", product);
};