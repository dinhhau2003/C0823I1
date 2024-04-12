package com.example.benh_an.repository;

import com.example.benh_an.model.BenhNhan;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BenhNhanRepository implements IBenhNhanRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_BENHNHAN= "select * from  benh_nhan ";

    @Override
    public List<BenhNhan> findAllBenhNhan() {
        List<BenhNhan> benhNhans = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_BENHNHAN)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_benh_nhan");
                    String name = resultSet.getString("ten_benh_nhan");
                    BenhNhan benhNhan=new BenhNhan(id,name);
                    benhNhans.add(benhNhan);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhNhans;
    }
}
