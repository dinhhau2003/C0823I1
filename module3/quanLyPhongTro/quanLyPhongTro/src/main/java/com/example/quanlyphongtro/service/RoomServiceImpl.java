package com.example.quanlyphongtro.service;

import com.example.quanlyphongtro.model.Room;
import com.example.quanlyphongtro.repository.RoomRepositoryImpl;

import java.util.List;

public class RoomServiceImpl implements IRoomService{
    RoomRepositoryImpl roomRepository=new RoomRepositoryImpl();
    @Override
    public List<Room> findAllRoom() {
        return roomRepository.findAllRoom();
    }

    @Override
    public void addProduct(Room room) {
        roomRepository.addProduct(room);
    }

    @Override
    public Room findById(int id) {
        return roomRepository.findById(id);
    }

    @Override
    public boolean deleteRoom(int id) {
        return roomRepository.deleteRoom(id);
    }

    @Override
    public void updateRoom(Room room) {
        roomRepository.updateRoom(room);
    }

    @Override
    public List<Room> search(String tenThanhToan, String name) {
        return roomRepository.search(tenThanhToan,name);
    }
}
