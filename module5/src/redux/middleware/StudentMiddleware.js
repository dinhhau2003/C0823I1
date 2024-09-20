import * as studentService from "../../service/StudentService"
export const getAllStudentsByMiddleware = () => {
    return async (dispatch) => {
        const data = await studentService.getAllStudents("");

        dispatch({
            type: "GET_ALL_STUDENTS",
            payload: data
        })
    }
}

export const addStudentByMiddleware = (student) => async (dispatch) => {
    const data = await studentService.addStudent(student);
    dispatch({
        type: "ADD_STUDENT",
        payload: data
    })
}