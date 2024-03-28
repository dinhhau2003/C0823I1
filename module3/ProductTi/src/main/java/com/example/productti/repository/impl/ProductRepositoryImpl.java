package com.example.productti.repository.impl;

import com.example.productti.model.Product;
import com.example.productti.repository.DBConnection;
import com.example.productti.repository.IProductRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository {
    DBConnection connection = new DBConnection();
    private static final String SELECT_FINDBYID = "select * from product where id = ?";
    private static final String UPDATE_PRODUCT = "update product set name = ?, day = ?, category_id = ? where id = ?";
    private static final String SEARCH="SELECT p.*, c.name_category FROM product p join category c on p.category_id = c.id_category where p.name like  concat('%',?,'%');";
    private static final String DELETE_PRODUCT = "delete from product where id=?;";
    private static final String SECLECT_ALL_PRODUCT = "select p.id, p.name, p.day, c.name_category from product p join category c on p.category_id = c.id_category;";
    private static final String ADD_PRODUCT = "insert into product(name, day, category_id) values (?, ?, ?)";
    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_PRODUCT)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    Date day = resultSet.getDate("day");
                    String nameCategory = resultSet.getString("name_category");
                    Product product = new Product(id, name, day, nameCategory);
                    products.add(product);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return products;
    }


    @Override
    public void addProduct(Product product) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_PRODUCT)) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDate(2, product.getDay());
            preparedStatement.setDouble(3, product.getIdCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean deleteProduct(int id) {
        boolean row = false;
        try {
            PreparedStatement statement =this.connection.getConnection().prepareStatement(DELETE_PRODUCT);
            statement.setInt(1,id);
            row = statement.executeUpdate()>0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBConnection.close();
        }
        return row;
    }

    @Override
    public List<Product> search(String name) {
        List<Product> productList = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                Date day = resultSet.getDate("day");
                String nameCategory = resultSet.getString("name_category");
                Product product = new Product(id, name, day, nameCategory);
                productList.add(product);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return productList;
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                Date day = rs.getDate("day");
                int categoryId = rs.getInt("category_id");
                product = new Product(id, name, day, categoryId);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;    }

    @Override
    public void updateProduct(Product product) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setDate(2, product.getDay());
            statement.setInt(3, product.getIdCategory());
            statement.setInt(4, product.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
