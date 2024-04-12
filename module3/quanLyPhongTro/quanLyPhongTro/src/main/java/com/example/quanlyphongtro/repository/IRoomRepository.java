package com.example.quanlyphongtro.repository;

import com.example.quanlyphongtro.model.Room;

import java.util.List;

public interface IRoomRepository {
    List<Room> findAllRoom();
    void addProduct(Room room);
    Room findById(int id);
    boolean deleteRoom(int id);
    void updateRoom(Room room);
    List<Room> search(String name, String tenThanhToan);
}
