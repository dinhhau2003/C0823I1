package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.model.Room;

import java.util.List;

public interface IRoomService {
    List<Room> findAllRoom();
    void addProduct(Room room);
    Room findById(int id);
    boolean deleteRoom(int id);
    void updateRoom(Room room);
    List<Room> search(String tenThanhToan,String name);
}
