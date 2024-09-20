import React from 'react';
import './Css/DeleteModal.css'

const ConfirmDelete = ({ onConfirm, onCancel, productName }) => {
    return (
        <div className="modal-overlay">
            <div className="modal-content">
                <p>Bạn có muốn xóa sách có tên là {productName} này không?</p>
                <button onClick={onConfirm}>Có</button>
                <button onClick={onCancel}>Không</button>
            </div>
        </div>
    );
};

export default ConfirmDelete;

