// src/services/tableService.js
import axios from 'axios';

const API_URL = "http://localhost:8080/api/table";

export const getAllTables = async (page = 0, size = 10) => {
    try {
        const response = await axios.get(`${API_URL}?page=${page}&size=${size}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching tables:", error);
        throw error;
    }
};
export const getTableById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching table by ID:", error);
        throw error;
    }
};
