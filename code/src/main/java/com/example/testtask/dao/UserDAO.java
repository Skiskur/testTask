package com.example.testtask.dao;

import com.example.testtask.entity.Card;
import com.example.testtask.entity.User;

import java.util.List;

public interface UserDAO {

    public List<User> getAllUsers();

    public void saveUser(User user);

    public User getUser(int id);

    public void deleteUser(int id);

}
