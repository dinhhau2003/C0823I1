import axios from "axios";

export const getAllCategory=async ()=>{
    try {
        let categories=await axios.get("http://localhost:3030/category");
        return categories.data
    }catch (e) {
        return []
    }
}