import {thunk} from "redux-thunk";
import {applyMiddleware, createStore} from "redux";
import rootReducer from "./reducer/RootReducer";

const middleware=[thunk];
const store=createStore(rootReducer,{},applyMiddleware(...middleware))
export default store;