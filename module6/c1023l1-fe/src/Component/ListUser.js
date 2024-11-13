import React, { useEffect, useState } from "react";
import { getUsers } from "../Service/UserService";

export default function UserList() {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    // Token được lấy từ Postman
    const token = 'eyJhbGciOiJIUzI1NiJ9.eyJ1c2VybmFtZSI6InRoYW9AMTIzNCIsInN1YiI6InRoYW9AMTIzNCIsImV4cCI6MTczMjk1NTI2N30.0tODNoqYjnXjg6cq_U5fTsPFUS-848KWR9tC6S1hLHw';

    useEffect(() => {
        const fetchData = async () => {
            try {
                const data = await getUsers(token);
                // Lọc chỉ những người dùng có lương > 0
                const filteredUsers = data.filter(user => user.salary > 0);
                setUsers(filteredUsers);
            } catch (error) {
                setError("Có lỗi xảy ra khi lấy danh sách người dùng.");
            }
            setLoading(false);
        };

        fetchData();
    }, []);

    if (loading) return <p>Đang tải...</p>;
    if (error) return <p>{error}</p>;

    return (
        <div>
            <h2>Danh Sách Người Dùng</h2>
            {users.length > 0 ? ( // Kiểm tra xem có người dùng nào không
                <table>
                    <thead>
                    <tr>
                        <th>STT</th>
                        <th>Tên tài khoản</th>
                        <th>Họ và tên</th>
                        <th>Địa chỉ</th>
                        <th>Số điện thoại</th>
                        <th>Giới tính</th>
                        <th>Ngày sinh</th>
                        <th>Lương</th>
                        <th>Vị trí</th>
                    </tr>
                    </thead>
                    <tbody>
                    {users.map((user, index) => (
                        <tr key={user.userId}>
                            <td>{index + 1}</td>
                            <td>{user.username}</td>
                            <td>{user.fullName}</td>
                            <td>{user.address}</td>
                            <td>{user.numberphone}</td>
                            <td>{user.gender ? "Nam" : "Nữ"}</td>
                            <td>{new Date(user.birthday).toLocaleDateString()}</td>
                            <td>{user.salary}</td>
                            <td>{user.role.roleName}</td>
                        </tr>
                    ))}
                    </tbody>
                </table>
            ) : (
                <p>Không có người dùng nào.</p> // Thông báo nếu không có người dùng nào
            )}
        </div>
    );
}
