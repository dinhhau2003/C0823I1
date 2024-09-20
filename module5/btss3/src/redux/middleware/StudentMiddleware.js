import * as studentService from "../../Service/StudentService"
export const getALlStudentsByMiddleware=()=>{
    return async (dispatch)=>{
        const data =await studentService.getAllStudents("");
        dispatch({
            type:"GET_ALL_STUDENTS",
            payload:data
        })
    }
}
export const addStudentByMiddleware1=(student)=>async (dispatch)=>{
    const data=await studentService.addStudent(student);
    dispatch({
        type:"ADD_STUDENT",
        payload:data
    })
}