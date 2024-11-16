// src/service/CategoryService.js
import axios from 'axios';

const API_URL = "http://localhost:8080/api/category"; // Đảm bảo đúng URL của API backend

// Lấy tất cả các danh mục
export const getAllCategories = async () => {
    try {
        const response = await axios.get(API_URL);
        console.log(response.data);
        return response.data.content; // Lấy danh sách categories từ response
    } catch (error) {
        console.error("Error fetching categories:", error);
        throw error;
    }
};

