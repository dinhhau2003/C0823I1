import axios from "axios";

const URL_STUDENT = "http://localhost:8080/students";

export const getAllStudents = async (name) => {
    try {
        const response = await axios.get(URL_STUDENT+"?name_like="+ name);
        return response.data;
    } catch (error) {
        console.error(error);
    }
}

export const addStudent = async (student) => {
    try {
        const res = await axios.post(URL_STUDENT, student);
        return res.data
    } catch (e) {
        console.log(e)
    }
}