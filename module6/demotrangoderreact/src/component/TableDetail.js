import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import { useNavigate } from 'react-router-dom';

import { getTableById } from '../service/TableService';
import { getAllCategories } from '../service/CategoryService';
import { getProductsByCategory } from '../service/ProductService';
import axios from 'axios';
import { ToastContainer, toast } from 'react-toastify'; // Import ToastContainer và toast
import 'react-toastify/dist/ReactToastify.css'; // Import CSS cho Toast

const TableDetail = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [table, setTable] = useState(null);
    const [categories, setCategories] = useState([]);
    const [products, setProducts] = useState([]);
    const [selectedProducts, setSelectedProducts] = useState([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchTableAndCategories = async () => {
            try {
                const tableData = await getTableById(id);
                setTable(tableData);

                const categoriesData = await getAllCategories();
                setCategories(categoriesData);
            } catch (error) {
                console.error("Error fetching data:", error);
            } finally {
                setLoading(false);
            }
        };

        fetchTableAndCategories();
    }, [id]);

    const handleCategoryClick = async (categoryCode) => {
        try {
            const productsData = await getProductsByCategory(categoryCode);
            setProducts(productsData);
        } catch (error) {
            console.error("Error fetching products:", error);
        }
    };

    const handleProductClick = (product) => {
        const productExists = selectedProducts.some(p => p.productId === product.productId);
        if (productExists) {
            const updatedProducts = selectedProducts.map(p =>
                p.productId === product.productId ? { ...p, quantity: p.quantity + 1 } : p
            );
            setSelectedProducts(updatedProducts);
        } else {
            setSelectedProducts([...selectedProducts, { ...product, quantity: 1 }]);
        }
    };

    const increaseQuantity = (productId) => {
        const updatedProducts = selectedProducts.map(product =>
            product.productId === productId ? { ...product, quantity: product.quantity + 1 } : product
        );
        setSelectedProducts(updatedProducts);
    };

    const decreaseQuantity = (productId) => {
        const updatedProducts = selectedProducts.map(product =>
            product.productId === productId && product.quantity > 1
                ? { ...product, quantity: product.quantity - 1 }
                : product
        );
        setSelectedProducts(updatedProducts);
    };

    const calculateTotalAmount = () => {
        return selectedProducts.reduce((total, product) => total + (product.productPrice * product.quantity), 0);
    };

    const handlePlaceOrder = async () => {
        if (selectedProducts.length === 0) {
            toast.error('Bạn cần chọn ít nhất một sản phẩm.');
            return;
        }

        const orderData = {
            user: { userId: 1 },  // Thay bằng id người dùng thực tế
            table: { tableId: table.tableId },
            products: selectedProducts.map(product => ({
                productId: product.productId,
                quantity: product.quantity,
                price: product.productPrice,
                shippingDay: "2024-11-14", // Thay bằng ngày thực tế
            })),
        };

        try {
            const response = await axios.post("http://localhost:8080/api/orders/place", orderData);
            toast.success('Đơn hàng đã được thanh toán thành công!');

            // Sau khi thanh toán thành công, cập nhật bàn đã thanh toán trong localStorage
            const paidTables = JSON.parse(localStorage.getItem('paidTables')) || [];
            if (!paidTables.includes(table.tableId)) {
                paidTables.push(table.tableId);
                localStorage.setItem('paidTables', JSON.stringify(paidTables));
            }
        } catch (error) {
            toast.error('Có lỗi xảy ra khi đặt đơn hàng.');
        }
    };

    const handleReset = () => {
        // Xóa bàn khỏi localStorage và quay về trang Admin
        const paidTables = JSON.parse(localStorage.getItem('paidTables')) || [];
        const updatedPaidTables = paidTables.filter(id => id !== table.tableId);
        localStorage.setItem('paidTables', JSON.stringify(updatedPaidTables));

        // Quay lại trang danh sách bàn
        navigate('/admin');
    };

    if (loading) return <p>Loading...</p>;
    if (!table) return <p>Table not found</p>;

    return (
        <div style={{ display: 'flex' }}>
            <div style={{ flex: 1, marginRight: '20px' }}>
                <h2>Chi Tiết Bàn</h2>
                <p><strong>Tên Bàn:</strong> {table.tableName}</p>

                <h3>Danh Sách Các Danh Mục</h3>
                <ul>
                    {categories.map(category => (
                        <li key={category.categoryId}>
                            <button onClick={() => handleCategoryClick(category.categoryCode)}>
                                {category.categoryName}
                            </button>
                        </li>
                    ))}
                </ul>

                <h3>Sản Phẩm Thuộc Danh Mục:</h3>
                <ul>
                    {products.map(product => (
                        <li key={product.productId}>
                            <button onClick={() => handleProductClick(product)}>
                                {product.productName} - {product.productPrice} VND
                            </button>
                        </li>
                    ))}
                </ul>
            </div>

            <div style={{ flex: 1 }}>
                <h3>Thông Tin Sản Phẩm</h3>
                <table border="1" style={{ width: '100%', marginTop: '20px' }}>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên Sản phẩm</th>
                        <th>Số lượng</th>
                        <th>Giá tiền</th>
                        <th>Tên bàn</th>
                    </tr>
                    </thead>
                    <tbody>
                    {selectedProducts.length > 0 ? (
                        selectedProducts.map((product, index) => (
                            <tr key={product.productId}>
                                <td>{index + 1}</td>
                                <td>{product.productName}</td>
                                <td>
                                    <div style={{ display: 'flex', alignItems: 'center' }}>
                                        <button onClick={() => increaseQuantity(product.productId)} style={{ marginRight: '10px' }}>+</button>
                                        <span>{product.quantity}</span>
                                        <button onClick={() => decreaseQuantity(product.productId)} style={{ marginLeft: '10px' }}>-</button>
                                    </div>
                                </td>
                                <td>{product.productPrice * product.quantity} VND</td>
                                <td>{table.tableName}</td>
                            </tr>
                        ))
                    ) : (
                        <tr>
                            <td colSpan="5">Chưa có sản phẩm nào.</td>
                        </tr>
                    )}
                    </tbody>
                </table>

                <h3>Tổng Tiền: {calculateTotalAmount()} VND</h3>
                <button onClick={handlePlaceOrder}>Tính Tiền</button>
                <button onClick={handleReset} style={{ marginTop: '10px' }}>Reset</button>
            </div>

            <ToastContainer />
        </div>
    );
};

export default TableDetail;
