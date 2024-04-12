package com.example.on_tap.repository;

import com.example.on_tap.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepositoryImpl{
    DBConnection connection = new DBConnection();
    private static final String SEARCH = "select p.id_product, p.name_product,p.gender,p.day,c.name_category from product p join category c on p.ma_category = c.id_category where c.name_category like ? and p.name_product like ?";

    private static final String DELETE= "delete from product where id_product = ?";

    private static final String UPDATE= "update product set name_product = ?, gender = ?,day = ?, ma_category = ? where id_product = ?";

    private static final String SELECT_FINDBYID = "select * from product where id_product = ?";

    private static final String ADD = "insert into product(name_product, gender,day,ma_category) values (?, ?, ?, ?);";

    private static final String SECLECT_ALL = "select p.id_product, p.name_product,p.gender,p.day,c.name_category from product p join category c on p.ma_category = c.id_category;";

    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id=resultSet.getInt("id_product");
                    String name = resultSet.getString("name_product");
                    Boolean gender=resultSet.getBoolean("gender");
                    Date day=resultSet.getDate("day");
                    String tenCategory=resultSet.getString("name_category");
                    Product product=new Product(id,name,gender,day,tenCategory);
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
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setString(1, product.getNameProduct());
            preparedStatement.setBoolean(2,product.isGender());
            preparedStatement.setDate(3, product.getDay());
            preparedStatement.setInt(4,product.getMaCategory());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Product findById(int id) {
        Product product = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name_product");
                Date day=rs.getDate("day");
                Boolean gender=rs.getBoolean("gender");
                int ma=rs.getInt("ma_category");
                product=new Product(id,name,gender,day,ma);
                // nhớ bỏ id

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product ;
    }

    @Override
    public void update(Product product) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, product.getNameProduct());
            statement.setBoolean(2,product.isGender());
            statement.setDate(3,product.getDay());
            statement.setInt(4, product.getMaCategory());
            statement.setInt(5,product.getIdProduct());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean row = false;
        try {
            PreparedStatement statement =this.connection.getConnection().prepareStatement(DELETE);
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
    public List<Product> search(String tenCategory, String name) {
        List<Product> productList = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + tenCategory + "%" );
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id=resultSet.getInt("id_product");
                 name = resultSet.getString("name_product");
                Boolean gender=resultSet.getBoolean("gender");
                Date day=resultSet.getDate("day");
                tenCategory=resultSet.getString("name_category");
                Product product=new Product(id,name,gender,day,tenCategory);
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
}
