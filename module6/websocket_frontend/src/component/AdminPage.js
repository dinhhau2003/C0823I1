import React, { useEffect, useState } from 'react';
import { connectWebSocket } from '../service/websocket';
import Modal from '@mui/material/Modal';
import Box from '@mui/material/Box';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';

const AdminPage = () => {
    const [open, setOpen] = useState(false); // Trạng thái mở modal
    const [currentCall, setCurrentCall] = useState(null); // Dữ liệu cuộc gọi hiện tại

    useEffect(() => {
        connectWebSocket((newCall) => {
            console.log("Received message:", newCall);

            // Kiểm tra dữ liệu hợp lệ
            if (newCall.tableId && newCall.userId && newCall.tableName) {
                setCurrentCall(newCall); // Đặt dữ liệu cho cuộc gọi hiện tại
                setOpen(true); // Mở modal
            } else {
                console.error("Received invalid data", newCall);
            }
        });
    }, []);

    const handleClose = () => {
        setOpen(false); // Đóng modal khi người dùng nhấn nút đóng
        setCurrentCall(null); // Xóa dữ liệu cuộc gọi hiện tại khi đóng modal
    };

    return (
        <div>
            <h1>Trang Admin</h1>

            {/* Modal thông báo cuộc gọi mới */}
            <Modal
                open={open}
                onClose={handleClose}
                aria-labelledby="modal-title"
                aria-describedby="modal-description"
            >
                <Box
                    sx={{
                        position: 'absolute',
                        top: '50%',
                        left: '50%',
                        transform: 'translate(-50%, -50%)',
                        width: 300,
                        bgcolor: 'background.paper',
                        border: '2px solid #000',
                        boxShadow: 24,
                        p: 4,
                        textAlign: 'center',
                    }}
                >
                    {currentCall && (
                        <>
                            <Typography id="modal-title" variant="h6" component="h2">
                                Gọi phục vụ từ {currentCall.tableName}
                            </Typography>
                            <Typography id="modal-description" sx={{ mt: 2 }}>
                                Thời gian: {new Date(currentCall.callTime).toLocaleString()}
                            </Typography>
                            <Button onClick={handleClose} sx={{ mt: 2 }} variant="contained" color="primary">
                                Đóng
                            </Button>
                        </>
                    )}
                </Box>
            </Modal>
        </div>
    );
};

export default AdminPage;
