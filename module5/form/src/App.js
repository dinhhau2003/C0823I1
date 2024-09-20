import React from "react";
import "./App.css";
import {BrowserRouter, Link, Route} from "react-router-dom";
import Home from "./Component/Home";
import Contact from "./Component/Contact";
import About from "./Component/About";

export default function App() {
  return (
      <div>
          <BrowserRouter>
            <Route path={"/"} element={<Home/>}></Route>
            <Route path={"/contact"} element={<Contact/>}></Route>
            <Route path={"/about"} element={<About/>}></Route>
          </BrowserRouter>

        <ul>
          <li>
            <Link to="/">Home</Link>
          </li>
          <li>
            <Link to="/about">About</Link>
          </li>
          <li>
            <Link to="/contact">Contact</Link>
          </li>
        </ul>
      </div>

  );



}