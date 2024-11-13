import React, { useState } from 'react';
import { ref, uploadBytesResumable, getDownloadURL } from 'firebase/storage'; // Import các phương thức từ Firebase Storage
import { storage } from './firebase'; // Import storage đã cấu hình

const UploadImage = () => {
    const [image, setImage] = useState(null);
    const [url, setUrl] = useState("");

    const handleImageChange = (e) => {
        if (e.target.files[0]) {
            setImage(e.target.files[0]);
        }
    };

    const handleUpload = () => {
        if (image) {
            const storageRef = ref(storage, `images/${image.name}`);
            const uploadTask = uploadBytesResumable(storageRef, image);

            uploadTask.on(
                "state_changed",
                (snapshot) => {
                    // Theo dõi tiến trình upload (có thể thêm hiển thị tiến độ nếu muốn)
                },
                (error) => {
                    console.error("Lỗi khi upload:", error);
                },
                () => {
                    // Lấy URL sau khi upload thành công
                    getDownloadURL(uploadTask.snapshot.ref).then((downloadURL) => {
                        setUrl(downloadURL);
                        console.log("URL ảnh:", downloadURL);
                    });
                }
            );
        }
    };

    return (
        <div>
            <input type="file" onChange={handleImageChange} />
            <button onClick={handleUpload}>Upload</button>
            <br />
            {url && <img src={url} alt="Uploaded image" />}
        </div>
    );
};

export default UploadImage;
