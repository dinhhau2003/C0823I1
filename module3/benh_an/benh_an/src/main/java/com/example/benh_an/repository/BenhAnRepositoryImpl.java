package com.example.benh_an.repository;

import com.example.benh_an.model.BenhAn;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BenhAnRepositoryImpl implements IBenhAnRepositoryImpl{
    DBConnection connection = new DBConnection();
    private static final String UPDATE= "update benh_an set ma_benh_an = ?, ma_benh_nhan = ?,ngay_nhap_vien = ?, ngay_ra_vien = ?,ly_do_nhap_vien = ? where id = ?";

    private static final String SELECT_FINDBYID = "select * from benh_an where id = ?";

    private static final String ADD = "insert into benh_an(ma_benh_an, ma_benh_nhan, ngay_nhap_vien,ngay_ra_vien,ly_do_nhap_vien) values ( ?, ?, ?, ?,?)";

    private static final String SECLECT_ALL = "select a.id,a.ma_benh_an, a.ma_benh_nhan,n.ten_benh_nhan,a.ngay_nhap_vien,a.ngay_ra_vien,a.ly_do_nhap_vien from benh_an a join benh_nhan n on a.ma_benh_nhan = n.ma_benh_nhan;";

    @Override
    public List<BenhAn> findAllBenhAn() {
        List<BenhAn> benhAns = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id=resultSet.getInt("id");
                    int maBenhAn=resultSet.getInt("ma_benh_an");
                    int maBenhNhan=resultSet.getInt("ma_benh_nhan");
                    String tenBenhNhan=resultSet.getString("ten_benh_nhan");
                    Date ngayNhapVien=resultSet.getDate("ngay_nhap_vien");
                    Date ngayRaVien=resultSet.getDate("ngay_ra_vien");
                    String lyDoNhapVien=resultSet.getString("ly_do_nhap_vien");
                    BenhAn benhAn=new BenhAn(id,maBenhAn,maBenhNhan,ngayNhapVien,ngayRaVien,lyDoNhapVien,tenBenhNhan);
                    benhAns.add(benhAn);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return benhAns;
    }

    @Override
    public void addBenhAn(BenhAn benhAn) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD)) {
            preparedStatement.setInt(1, benhAn.getMaBenhAn());
            preparedStatement.setInt(2,benhAn.getMaBenhNhan());
            preparedStatement.setDate(3,benhAn.getDayNhapVien());
            preparedStatement.setDate(4,benhAn.getDayXuatVien());
            preparedStatement.setString(5,benhAn.getLyDoNhapVien());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public BenhAn findById(int id) {
        BenhAn benhAn = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maBenhAn=rs.getInt("ma_benh_an");
                int maBenhNhan=rs.getInt("ma_benh_nhan");
                Date dayNhap=rs.getDate("ngay_nhap_vien");
                Date dayXuat=rs.getDate("ngay_ra_vien");
                String lyDo=rs.getString("ly_do_nhap_vien");
                benhAn=new BenhAn(id,maBenhAn,maBenhNhan,dayNhap,dayXuat,lyDo);
                // nhớ bỏ id

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return benhAn ;
    }

    @Override
    public void update(BenhAn benhAn) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, benhAn.getMaBenhAn());
            statement.setInt(2,benhAn.getMaBenhNhan());
            statement.setDate(3,benhAn.getDayNhapVien());
            statement.setDate(4,benhAn.getDayXuatVien());
            statement.setString(5,benhAn.getLyDoNhapVien());
            statement.setInt(6,benhAn.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
