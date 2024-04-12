package com.example.thi_dto.repository;

import com.example.thi_dto.dto.ProductDto;
import com.example.thi_dto.model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements IProductRepository{
    DBConnection connection = new DBConnection();



    private static final String GET_ALL_DTO = "select p.id_product, p.name, p.gia,p.soLuong,p.color,p.moTa, c.ten_danh_muc from product p join category c on p.id_category = c.id_category;";
    private static final String ADD_PRODUCT = "insert into product(name, gia,soLuong,color,moTa, id_category) values (?, ?, ?, ?, ?, ?)";

    @Override
    public List<ProductDto> findAllDto() {
        List<ProductDto> productList = new ArrayList<>();
        Connection conn = null;
        conn = DBConnection.getConnection();

        try {
            PreparedStatement preparedStatement =  conn.prepareStatement(GET_ALL_DTO);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int idProduct = resultSet.getInt("id_product");
                String name = resultSet.getString("name");
                Float gia= resultSet.getFloat("gia");
                String soLuong=resultSet.getString("soLuong");
                String color=resultSet.getString("color");
                String moTa=resultSet.getString("moTa");
                String tenDanhMuc=resultSet.getString("ten_danh_muc");
                ProductDto productDto = new ProductDto(idProduct, name, gia,soLuong,color,moTa,tenDanhMuc);
                productList.add(productDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return productList;
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
    public boolean deleteProduct(int id) {
        return false;
    }
}
