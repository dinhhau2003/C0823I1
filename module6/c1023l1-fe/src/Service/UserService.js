import axios from "axios";

// URL của API backend
const API_URL = "http://localhost:8080/api";

// Hàm gọi API để lấy danh sách người dùng
export const getUsers = async (token) => {
    try {
        const response = await axios.get(`${API_URL}/users`, {
            headers: {
                Authorization: `Bearer ${token}`,
            },
        });
        return response.data;
    } catch (error) {
        console.error("Error fetching users:", error);
        throw error;
    }
};