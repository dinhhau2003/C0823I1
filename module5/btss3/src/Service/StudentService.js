import axios from "axios";

const URL_STUDENT="http://localhost:8080/students";
export const getAllStudents= async ()=>{
    try{
        const response= await axios.get(URL_STUDENT);
        return response.data;
    }catch (e){
        console.log(e);
    }
}
export const addStudent=async (student)=>{
    try {
        const res=await axios.post("http://localhost:8080/students",student);
        return res.data
    }catch (e){
        console.log(e)
    }
}