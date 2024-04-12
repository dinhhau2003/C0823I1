package com.example.thi.repository;

import com.example.thi.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{
    DBConnection connection = new DBConnection();
    private static final String DELETE_PRODUCT = "delete from product where id_product = ?";

    private static final String SELECT_FINDBYID = "select * from product where id_product = ?";
    private static final String UPDATE_PRODUCT = "update product set name = ?, gia = ?,soLuong=?, color= ?,moTa=?, id_category = ? where id_product = ?";

    private static final String ADD_PRODUCT = "insert into product(name, gia,soLuong,color,moTa, id_category) values (?, ?, ?, ?, ?, ?)";


    private static final String SECLECT_ALL_PRODUCT = "select p.id_product, p.name, p.gia,p.soLuong,p.color,p.moTa, c.ten_danh_muc from product p join category c on p.id_category = c.id_category;";
    private static final String SEARCH = "select p.id_product, p.name, p.gia,p.soLuong,p.color,p.moTa, c.ten_danh_muc from product p join category c on p.id_category = c.id_category where c.ten_danh_muc like ? and p.name like ?";

    @Override
    public List<Product> findAllProduct() {
        List<Product> products = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_PRODUCT)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int idProduct = resultSet.getInt("id_product");
                    String name = resultSet.getString("name");
                    Float gia= resultSet.getFloat("gia");
                    String soLuong=resultSet.getString("soLuong");
                    String color=resultSet.getString("color");
                    String moTa=resultSet.getString("moTa");
                    String tenDanhMuc=resultSet.getString("ten_danh_muc");
                    Product product = new Product(idProduct, name, gia,soLuong,color,moTa,tenDanhMuc);
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
            preparedStatement.setFloat(2, product.getGia());
            preparedStatement.setString(3,product.getSoLuong());
            preparedStatement.setString(4,product.getColor());
            preparedStatement.setString(5,product.getMoTa());
            preparedStatement.setInt(6,product.getId_category());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateProduct(Product product) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE_PRODUCT)) {
            statement.setString(1, product.getName());
            statement.setFloat(2,product.getGia());
            statement.setString(3,product.getSoLuong());
            statement.setString(4,product.getColor());
            statement.setString(5,product.getMoTa());
            statement.setInt(6, product.getId_category());
            statement.setInt(7, product.getId_product());
            statement.executeUpdate();
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
                String name = rs.getString("name");
                Float gia=rs.getFloat("gia");
                String soLuong=rs.getString("soLuong");
                String color=rs.getString("color");
                String moTa=rs.getString("moTa");
                int id_category = rs.getInt("id_category");
                product = new Product(id,name,gia,soLuong,color,moTa,id_category );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return product;
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
    public List<Product> search(String tenDanhMuc, String name) {
        List<Product> productList = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + tenDanhMuc + "%" );
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id_product");
                name = resultSet.getString("name");
                Float gia= resultSet.getFloat("gia");
                String soLuong=resultSet.getString("soLuong");
                String color=resultSet.getString("color");
                String moTa=resultSet.getString("moTa");
                tenDanhMuc=resultSet.getString("ten_danh_muc");
                Product product = new Product(idProduct, name, gia,soLuong,color,moTa,tenDanhMuc);
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
