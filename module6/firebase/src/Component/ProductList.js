import React, { useEffect, useState } from 'react';
import axios from 'axios'; // Dùng để gọi API từ backend

const ProductList = () => {
    const [products, setProducts] = useState([]);

    useEffect(() => {
        // Lấy danh sách sản phẩm từ backend
        axios.get('http://localhost:8080/api/products/list')
            .then(response => {
                setProducts(response.data);
            })
            .catch(error => {
                console.error('Lỗi khi lấy danh sách sản phẩm:', error);
            });
    }, []);

    return (
        <div>
            <h2>Danh sách sản phẩm</h2>
            <ul>
                {products.map(product => (
                    <li key={product.id}>
                        <img src={product.imageUrl} alt={product.name} width="100" />
                        <p>Tên: {product.name}</p>
                        <p>Giá: {product.price}</p>
                        <p>Số lượng: {product.quantity}</p>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default ProductList;
