import axios from "axios";

export const getAll = async () => {
    try {
        const query = "http://localhost:8080/employee/list";
        const result = await axios.get(query);
        return result.data;
    } catch (error) {
        console.error("Error fetching employee data:", error);
    }
};
export const saveEmployee=async (employee)=>{
    try {
        await axios.post("http://localhost:8080/employee/add", employee);
        return true;
    }catch (e) {
        return false
    }
}
export const getEmployeeById = async (id) => {
    try {
        const response = await axios.get(`http://localhost:8080/employee/${id}`);
        return response.data;
    } catch (error) {
        console.error("Error fetching employee:", error);
        return null;
    }
};

export const updateEmployee = async (id, employee) => {
    try {
        const response = await axios.post(`http://localhost:8080/employee/update/${id}`, employee);
        return response.data;
    } catch (error) {
        console.error("Error updating employee:", error);
        return null;
    }
};
