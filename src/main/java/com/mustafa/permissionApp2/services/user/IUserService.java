package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.jpa.entities.User;

import java.util.List;

public interface IUserService {
    public void addUser(User userDto);
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public User getUser(int id);
}
