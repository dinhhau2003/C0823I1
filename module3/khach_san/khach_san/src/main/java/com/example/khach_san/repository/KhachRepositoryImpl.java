package com.example.khach_san.repository;

import com.example.khach_san.model.KhachHang;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KhachRepositoryImpl implements IKhachRepositoryImpl{
    DBConnection connection = new DBConnection();
    private static final String SEARCH = "select k.ma_khach_hang, k.ho_ten, k.ngay_sinh,k.gioi_tinh, k.so_cmnd,l.ten_loai_khach from khach_hang k join loai_khach l on k.ma_loai_khach = l.ma_loai_khach where l.ten_loai_khach like ? and k.ho_ten like ?";

    private static final String UPDATE= "update khach_hang set ma_loai_khach = ?, ho_ten = ?,ngay_sinh = ?, gioi_tinh = ?,so_cmnd = ? where ma_khach_hang = ?";

    private static final String SELECT_FINDBYID = "select * from khach_hang where ma_khach_hang = ?";

    private static final String DELETE= "delete from khach_hang where ma_khach_hang = ?";

    private static final String ADD = "insert into khach_hang(ma_loai_khach, ho_ten,ngay_sinh, gioi_tinh,so_cmnd) values (?, ?, ?, ?, ?)";

    private static final String SECLECT_ALL_ROOM = "select k.ma_khach_hang, k.ho_ten,k.ngay_sinh,k.gioi_tinh,k.so_cmnd,l.ten_loai_khach from khach_hang k join loai_khach l on k.ma_loai_khach = l.ma_loai_khach;";

    @Override
    public List<KhachHang> findAllKhach() {
        List<KhachHang> khachHangs = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_ROOM)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("ma_khach_hang");
                    String name = resultSet.getString("ho_ten");
                    Date day=resultSet.getDate("ngay_sinh");
                    Boolean gioiTinh=resultSet.getBoolean("gioi_tinh");
                    String cmnd=resultSet.getString("so_cmnd");
                    String tenLoaiKhach=resultSet.getString("ten_loai_khach");
                    KhachHang khachHang=new KhachHang(id,name,day,gioiTinh,cmnd,tenLoaiKhach);
                    khachHangs.add(khachHang);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return khachHangs;
    }

    @Override
    public void addKhachHang(KhachHang khachHang) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setInt(1, khachHang.getMaLoaiKhach());
            preparedStatement.setString(2, khachHang.getHoTen());
            preparedStatement.setDate(3,khachHang.getDay());
            preparedStatement.setBoolean(4,khachHang.isGioiTinh());
            preparedStatement.setString(5,khachHang.getSoCMND());
            preparedStatement.executeUpdate();
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
    public KhachHang findById(int id) {
        KhachHang khachHang = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maLoaiKhach=rs.getInt("ma_loai_khach");
                String name = rs.getString("ho_ten");
                Date day=rs.getDate("ngay_sinh");
                Boolean gender=rs.getBoolean("gioi_tinh");
                String cmnd=rs.getString("so_cmnd");
                // nhớ bỏ id
                khachHang=new KhachHang(id,maLoaiKhach,name,day,gender,cmnd);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return khachHang ;
    }

    @Override
    public void update(KhachHang khachHang) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, khachHang.getMaLoaiKhach());
            statement.setString(2, khachHang.getHoTen());
            statement.setDate(3,khachHang.getDay());
            statement.setBoolean(4,khachHang.isGioiTinh());
            statement.setString(5,khachHang.getSoCMND());
            statement.setInt(6,khachHang.getMaKhachHang());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<KhachHang> search( String tenLoaiKhach,String name) {
        List<KhachHang> khachHangList = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + tenLoaiKhach + "%" );
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("ma_khach_hang");
                name = resultSet.getString("ho_ten");
                Date day=resultSet.getDate("ngay_sinh");
                Boolean gender=resultSet.getBoolean("gioi_tinh");
                String cmnd =resultSet.getString("so_cmnd");
                tenLoaiKhach=resultSet.getString("ten_loai_khach");
                KhachHang khachHang=new KhachHang(id,name,day,gender,cmnd,tenLoaiKhach);
                khachHangList.add(khachHang);
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
        return khachHangList;
    }
}
