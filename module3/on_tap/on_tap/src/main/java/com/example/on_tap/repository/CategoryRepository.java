package com.example.on_tap.repository;

import com.example.on_tap.model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository implements ICategoryRepository{
    DBConnection connection = new DBConnection();
    private static final String SECLECT_ALL_CATEGORY= "select * from  category ";
    @Override
    public List<Category> findAllCategory() {
        List<Category> categorys = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_CATEGORY)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id_category");
                    String name = resultSet.getString("name_category");
                    Category category=new Category(id,name);
                    categorys.add(category);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return categorys;
    }
}
