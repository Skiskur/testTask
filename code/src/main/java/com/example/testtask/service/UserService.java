package com.example.testtask.service;

import com.example.testtask.entity.Card;
import com.example.testtask.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public User getUser(int id);

    public void saveUser(User user);

    public void deleteUser(int id);

}
