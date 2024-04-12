package com.example.quanlyphongtro.repository;

import com.example.quanlyphongtro.model.Pay;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayRepositoryImpl implements IPayRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_CATEGORY = "select * from  pay ";
    @Override
    public List<Pay> findAllPay() {
        List<Pay> pays = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_CATEGORY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("ten_thanh_toan");
                    Pay pay=new Pay(id,name);
                    pays.add(pay);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return pays;
    }
}
