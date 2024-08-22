package com.mustafa.permissionApp2.jpa.repositories;

import com.mustafa.permissionApp2.jpa.entities.User;


import java.util.List;

public interface IUserDao {
    public void addUser(User user);
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public User getUser(int id);
}
