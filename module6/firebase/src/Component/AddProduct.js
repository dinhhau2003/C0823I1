import React, { useState } from 'react';
import { ref, uploadBytesResumable, getDownloadURL } from 'firebase/storage';
import { storage } from '../firebase'; // Import storage đã cấu hình
import axios from 'axios'; // Dùng để gọi API từ backend

const AddProduct = () => {
    const [productName, setProductName] = useState('');
    const [price, setPrice] = useState('');
    const [quantity, setQuantity] = useState('');
    const [image, setImage] = useState(null);
    const [isUploading, setIsUploading] = useState(false); // Để quản lý trạng thái upload

    const handleImageChange = (e) => {
        if (e.target.files[0]) {
            setImage(e.target.files[0]);
        }
    };

    const handleAddProduct = async () => {
        if (!image) {
            alert("Vui lòng chọn ảnh trước khi thêm sản phẩm!");
            return;
        }

        try {
            setIsUploading(true); // Bắt đầu quá trình upload

            // Upload ảnh lên Firebase Storage và lấy URL
            const storageRef = ref(storage, `images/${image.name}`);
            const uploadTask = uploadBytesResumable(storageRef, image);

            // Chờ ảnh upload hoàn tất và lấy URL
            const downloadURL = await new Promise((resolve, reject) => {
                uploadTask.on(
                    'state_changed',
                    null,
                    (error) => reject(error), // Xử lý lỗi upload
                    () => {
                        getDownloadURL(uploadTask.snapshot.ref).then(resolve);
                    }
                );
            });

            // Sau khi có URL của ảnh, gửi sản phẩm lên backend
            const newProduct = {
                name: productName,
                price: parseFloat(price),
                quantity: parseInt(quantity),
                imageUrl: downloadURL,
            };

            // Gọi API để thêm sản phẩm
            const response = await axios.post('http://localhost:8080/api/products/add', newProduct);
            console.log("Sản phẩm được thêm thành công:", response.data);

            // Reset form sau khi thêm thành công
            setProductName('');
            setPrice('');
            setQuantity('');
            setImage(null);
        } catch (error) {
            console.error("Lỗi khi thêm sản phẩm:", error);
        } finally {
            setIsUploading(false); // Kết thúc quá trình upload
        }
    };

    return (
        <div>
            <h2>Thêm sản phẩm mới</h2>
            <input
                type="text"
                placeholder="Tên sản phẩm"
                value={productName}
                onChange={(e) => setProductName(e.target.value)}
            />
            <input
                type="number"
                placeholder="Giá sản phẩm"
                value={price}
                onChange={(e) => setPrice(e.target.value)}
            />
            <input
                type="number"
                placeholder="Số lượng sản phẩm"
                value={quantity}
                onChange={(e) => setQuantity(e.target.value)}
            />
            <input type="file" onChange={handleImageChange} />
            <br />
            {isUploading ? <p>Đang upload ảnh...</p> : null}
            <button onClick={handleAddProduct}>Thêm sản phẩm</button>
        </div>
    );
};

export default AddProduct;
