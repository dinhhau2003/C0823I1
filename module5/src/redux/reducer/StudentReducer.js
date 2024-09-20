const studentReducer = (students = [], action) => {
    switch (action.type) {
        case "ADD_STUDENT":
            return [...students, action.payload]
        case "REMOVE_STUDENT":
        case "EDIT_STUDENT":
        case "GET_ALL_STUDENTS":
              return action.payload
        default:
            return students;
    }
}
export default studentReducer;