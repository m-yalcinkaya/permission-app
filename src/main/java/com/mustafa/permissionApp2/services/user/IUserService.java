package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.dto.CreateUserRequest;
import com.mustafa.permissionApp2.jpa.entities.User;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    public void deleteUser(int id);
    public List<User> getAllUsers();
    public User getUser(int id);
    public User createUser(CreateUserRequest request);
    public UserDetails loadUserByUsername(String username);
}
