// src/service/ProductService.js
import axios from 'axios';

const API_URL = "http://localhost:8080/api/product"; // URL cho các API Product

// API để lấy sản phẩm theo mã danh mục
export const getProductsByCategory = async (categoryCode) => {
    try {
        const response = await axios.get(`${API_URL}/category/${categoryCode}`);
        return response.data.content; // Trả về danh sách sản phẩm từ response
    } catch (error) {
        console.error("Error fetching products by category:", error);
        throw error;
    }
};
