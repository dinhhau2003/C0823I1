import {combineReducers} from "redux";
import studentReducer from "./StudentReducer";

const rootReducer=combineReducers({
    students:studentReducer
})
export default rootReducer;