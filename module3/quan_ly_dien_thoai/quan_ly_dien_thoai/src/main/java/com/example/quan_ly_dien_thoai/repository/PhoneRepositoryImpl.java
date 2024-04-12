package com.example.quan_ly_dien_thoai.repository;

import com.example.quan_ly_dien_thoai.model.Phone;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PhoneRepositoryImpl implements IPhoneRepository{
    DBConnection dbConnection = new DBConnection();
    private static final String SELECT_ALL_Phone ="select phone.id, phone.name, phone.price, danh_muc.ten_danh_muc from phone join danh_muc on phone.id_danh_muc = danh_muc.id_danh_muc where phone.id=?;";
    private static final String INSERT_PHONE_SQL = "INSERT INTO phone" + " (name,price,id_danh_muc)VALUES"+" (?,?,?);";
    @Override
    public List<Phone> findAll() {
        List<Phone> phoneList = new ArrayList<>();
        Connection connection = DBConnection.getConnectDB();
        if(connection!=null){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_Phone);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()){
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    double price = resultSet.getDouble("price");
                    String ten_danh_muc = resultSet.getString("ten_danh_muc");
                    Phone phone=new Phone(id,name,price,ten_danh_muc);
                    phoneList.add(phone);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return phoneList;
    }

    @Override
    public void addNewPhone(Phone phone) {
        System.out.println(INSERT_PHONE_SQL);
        try (Connection connection = DBConnection.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PHONE_SQL)){
            preparedStatement.setString(1,phone.getName());
            preparedStatement.setDouble(2,phone.getPrice());
            preparedStatement.setInt(3,phone.getId_danh_muc());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
