package com.example.quanlyphongtro.repository;

import com.example.quanlyphongtro.model.Room;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoomRepositoryImpl implements IRoomRepository{
    private static final String SEARCH = "select r.id, r.name, r.phone,r.day, p.ten_thanh_toan from room r join pay p on r.id_thanh_toan = p.id where p.ten_thanh_toan like ? and r.name like ?";

    DBConnection connection = new DBConnection();
    private static final String UPDATE_ROOM= "update room set name = ?, phone = ?,day = ?, id_thanh_toan = ? where id = ?";

    private static final String DELETE_ROOM = "delete from room where id = ?";

    private static final String SELECT_FINDBYID = "select * from room where id = ?";

    private static final String ADD_ROOM = "insert into room(name, phone,day, id_thanh_toan) values (?, ?, ?, ?)";

    private static final String SECLECT_ALL_ROOM = "select r.id, r.name, r.phone,r.day,p.ten_thanh_toan from room r join pay p on r.id_thanh_toan = p.id;";

    @Override
    public List<Room> findAllRoom() {
        List<Room> rooms = new ArrayList<>();
        if (connection != null) {
            try (PreparedStatement preparedStatement = DBConnection.getConnection().prepareStatement(SECLECT_ALL_ROOM)) {
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String phone= resultSet.getString("phone");
                    Date day=resultSet.getDate("day");
                    String tenThanhToan=resultSet.getString("ten_thanh_toan");
                    Room room=new Room(id,name,phone,day,tenThanhToan);
                    rooms.add(room);
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return rooms;
    }

    @Override
    public void addProduct(Room room) {
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(ADD_ROOM)) {
            preparedStatement.setString(1, room.getName());
            preparedStatement.setString(2, room.getPhone());
            preparedStatement.setDate(3,room.getDay());
            preparedStatement.setInt(4,room.getIdThanhToan());
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Room findById(int id) {
        Room room = null;
        try (Connection connection = DBConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_FINDBYID)) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                String phone=rs.getString("phone");
                Date day=rs.getDate("day");
                int idThanhToan = rs.getInt("id_thanh_toan");
                room =new Room(id,name,phone,day,idThanhToan);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return room;
    }

    @Override
    public boolean deleteRoom(int id) {
        boolean row = false;
        try {
            PreparedStatement statement =this.connection.getConnection().prepareStatement(DELETE_ROOM);
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
    public void updateRoom(Room room) {
        try (PreparedStatement statement = this.connection.getConnection().prepareStatement(UPDATE_ROOM)) {
                statement.setString(1, room.getName());
                statement.setString(2, room.getPhone());
                statement.setDate(3,room.getDay());
                statement.setInt(4,room.getIdThanhToan());
                statement.setInt(5, room.getId());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
    @Override
    public List<Room> search(String tenThanhToan, String name) {
        List<Room> roomList = new ArrayList<>();
        // kết nối DB
        Connection connection = DBConnection.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SEARCH);
            preparedStatement.setString(1, "%" + tenThanhToan + "%" );
            preparedStatement.setString(2, "%" + name + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                name = resultSet.getString("name");
                String phone= resultSet.getString("phone");
                Date day=resultSet.getDate("day");
                tenThanhToan=resultSet.getString("ten_thanh_toan");
                Room room=new Room(id,name,phone,day,tenThanhToan);
                roomList.add(room);
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
        return roomList;
    }
}
