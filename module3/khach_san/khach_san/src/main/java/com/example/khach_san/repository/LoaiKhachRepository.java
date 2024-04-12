package com.example.khach_san.repository;

import com.example.khach_san.model.LoaiKhach;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiKhachRepository implements ILoaiKhachRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_LOAIKHACH = "select * from  loai_khach ";

    @Override
    public List<LoaiKhach> findAllLoaiKhach() {
        List<LoaiKhach> loaiKhachs = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_LOAIKHACH)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_loai_khach");
                    String name = resultSet.getString("ten_loai_khach");
                    LoaiKhach loaiKhach=new LoaiKhach(id,name);
                    loaiKhachs.add(loaiKhach);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return loaiKhachs;
    }
}
