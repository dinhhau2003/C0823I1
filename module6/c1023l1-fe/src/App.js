import logo from './logo.svg';
import './App.css';
import {NavLink, Route, Routes} from "react-router-dom";
import ListUser from "./Component/ListUser";

function App() {
  return (
   <div className="App">
     <nav>
         {/*<NavLink to="/users">Users</NavLink>*/}

     </nav>
     <Routes>
       <Route path="/" element={<ListUser/>}></Route>
     </Routes>
   </div>
  );
}

export default App;
