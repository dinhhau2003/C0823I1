package com.example.hanghoa.repository;

import com.example.hanghoa.model.LoaiHang;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiHangRepository implements ILoaiHangRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_LOAIHANG= "select * from  loai_hang ";
    @Override
    public List<LoaiHang> findAllLoaiHang() {
        List<LoaiHang> loaiHangs = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_LOAIHANG)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_loai_hang");
                    String name = resultSet.getString("ten_loai_hang");
                    LoaiHang loaiHang=new LoaiHang(id,name);
                    loaiHangs.add(loaiHang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return loaiHangs;
    }
}
