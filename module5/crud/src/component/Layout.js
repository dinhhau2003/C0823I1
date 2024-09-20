import React from "react";
import { Link, Outlet } from "react-router-dom";
import { ToastContainer } from "react-toastify";

export const Layout = () => {
    return (
        <div className="container">
            <nav>
                <ul>
                    <li>
                        <Link to="/">List</Link>
                    </li>
                    <li>
                        <Link to="/create">Create</Link>
                    </li>
                </ul>
            </nav>

            <Outlet />

            <footer>Footer</footer>
            <ToastContainer />
        </div>
    );
};
