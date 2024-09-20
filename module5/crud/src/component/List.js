// component/List.js
import React, {useEffect, useState} from 'react';
import {getProducts} from "../service/productService";
import {date} from "yup";
import data from "bootstrap/js/src/dom/data";  // Import React (cần thiết khi sử dụng JSX)

export const List = () => {
    const [products, setProducts] = useState([]);
    useEffect(() => {
        findAllProducts();
    }, []);
    const findAllProducts = () => {
        getProducts().then((data) => {
            setProducts(data);
        });
    };


    return (
        <div>
            <table className="table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Category</th>
                    <th>Delete</th>
                    <th>Update</th>
                </tr>
                </thead>
                <tbody>
                {
                    products.map((product) => (
                            <tr key={product.id}>
                                <td>{product.id}</td>
                                <td>{product.name}</td>
                                <td>{product.price}</td>
                                <td>{product.category.name}</td>
                            </tr>

                        )
                    )
                }
                </tbody>
            </table>
        </div>
    );
};
