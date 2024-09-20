import axios from "axios";

export const getAllClothes=async (name,category)=>{
    try {
        let query="http://localhost:3030/clothes?";
        if (name){
            query +=`name_like=${name}&`;
        }
        if (category) {  // Nếu có category ID, thêm vào chuỗi truy vấn
            query += `category.id=${category}&`;
        }
        let result=await axios.get(query);
        return result.data
    }catch (e) {
        console.log(e)
    }
};
export const saveClothe = async (clothe) => {
    try {
        await axios.post("http://localhost:3030/clothes", clothe)
        return true;
    } catch (err) {
        return false
    }
}
export const updateClothe = async (id, updatedClothe) => {
    try {
        await axios.patch(`http://localhost:3030/clothes/${id}`, updatedClothe);
        return true;
    } catch (err) {
        return false;
    }
}
export const deleteClothe = async (id) => {
    try {
        await axios.delete(`http://localhost:3030/clothes/${id}`);
        return true;
    } catch (err) {
        return false;
    }
}
