package com.example.hanghoa.repository;

import com.example.hanghoa.model.HangHoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HangRepositoryImpl implements IHangRepositoryImpl {
    DBConnection connection = new DBConnection();
    private static final String SEARCH = "select h.ma_hang_hoa, h.ten_hang_hoa,h.don_vi_tinh,h.gia,h.day,l.ten_loai_hang from hang_hoa h join loai_hang l on h.ma_loai_hang = l.ma_loai_hang where l.ten_loai_hang like ? and h.ten_hang_hoa like ?";

    private static final String DELETE = "delete from hang_hoa where ma_hang_hoa = ?";

    private static final String UPDATE = "update hang_hoa set ten_hang_hoa = ?, don_vi_tinh = ?, gia = ? , day = ?, ma_loai_hang = ? where ma_hang_hoa = ?";

    private static final String SELECT_FINDBYID = "select * from hang_hoa where ma_hang_hoa = ?";

    private static final String ADD = "insert into hang_hoa(ten_hang_hoa, don_vi_tinh,gia,day,ma_loai_hang) values (?, ?, ?, ?,?);";

    private static final String SECLECT_ALL = "select h.ma_hang_hoa, h.ten_hang_hoa,h.don_vi_tinh,h.gia,h.day,l.ten_loai_hang from hang_hoa h join loai_hang l on h.ma_loai_hang = l.ma_loai_hang;";

    @Override
    public List<HangHoa> findAllHang() {
        List<HangHoa> hangHoas = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_hang_hoa");
                    String name = resultSet.getString("ten_hang_hoa");
                    String dvt = resultSet.getString("don_vi_tinh");
                    Double gia = resultSet.getDouble("gia");
                    Date day = resultSet.getDate("day");
                    String tenLoaiHang = resultSet.getString("ten_loai_hang");
                    HangHoa hangHoa = new HangHoa(id, name, dvt, gia, day, tenLoaiHang);
                    hangHoas.add(hangHoa);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return hangHoas;
    }

    @Override
    public void addHang(HangHoa hangHoa) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setString(1, hangHoa.getTenHangHoa());
            preparedStatement.setString(2, hangHoa.getDonViTinh());
            preparedStatement.setDouble(3, hangHoa.getGia());
            preparedStatement.setDate(4, hangHoa.getDay());
            preparedStatement.setInt(5, hangHoa.getMaLoaiHang());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public HangHoa findById(int id) {
        HangHoa hangHoa = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("ten_hang_hoa");
                String dvt = rs.getString("don_vi_tinh");
                Double gia = rs.getDouble("gia");
                Date day = rs.getDate("day");
                int ma = rs.getInt("ma_loai_hang");
                hangHoa = new HangHoa(id, name, dvt, gia, day, ma);
                // nhớ bỏ id

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return hangHoa;
    }

    @Override
    public void update(HangHoa hangHoa) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, hangHoa.getTenHangHoa());
            statement.setString(2, hangHoa.getDonViTinh());
            statement.setDouble(3, hangHoa.getGia());
            statement.setDate(4, hangHoa.getDay());
            statement.setInt(5, hangHoa.getMaLoaiHang());
            statement.setInt(6, hangHoa.getMaHangHoa());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        boolean row = false;
        try {
            PreparedStatement statement = this.connection.getConnection().prepareStatement(DELETE);
            statement.setInt(1, id);
            row = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBConnection.close();
        }
        return row;
    }

    @Override
    public List<HangHoa> search(String tenLoaiHang, String name) {
        List<HangHoa> hangHoas = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + tenLoaiHang + "%");
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_hang_hoa");
                name = resultSet.getString("ten_hang_hoa");
                String dvt = resultSet.getString("don_vi_tinh");
                Double gia = resultSet.getDouble("gia");
                Date day = resultSet.getDate("day");
                tenLoaiHang = resultSet.getString("ten_loai_hang");
               HangHoa hangHoa=new HangHoa(id,name,dvt,gia,day,tenLoaiHang);
               hangHoas.add(hangHoa);
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
        return hangHoas;
    }
}
