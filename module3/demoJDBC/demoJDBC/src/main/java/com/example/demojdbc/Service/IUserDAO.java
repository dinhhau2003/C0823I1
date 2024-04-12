package com.example.demojdbc.Service;

import com.example.demojdbc.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    public List<User> selectAllUsers();
    public void insertUser(User user) throws SQLException;
}
