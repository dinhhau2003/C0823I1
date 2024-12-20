package com.example.thi_dto.repository;

import com.example.thi_dto.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements ICategoryRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_CATEGORY = "select * from  category ";
    private static final String DELETE_PRODUCT = "delete from product where id_product = ?";


    @Override
    public List<Category> findAllCategory() {
        List<Category> categories = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_CATEGORY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_category");
                    String name = resultSet.getString("ten_danh_muc");
                    Category category = new Category(id, name);
                    categories.add(category);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return categories;
    }
}
