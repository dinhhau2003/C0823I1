import {combineReducers} from "redux";
import studentReducer from "./StudentReducer";

const rootReducer = combineReducers({
    students: studentReducer
    // teachers: teacherReducer,
    // username: usernameReducer
})

export default rootReducer;