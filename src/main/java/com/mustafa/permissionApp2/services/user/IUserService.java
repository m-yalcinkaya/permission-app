package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.dto.UserDto;
import com.mustafa.permissionApp2.jpa.entities.User;

import java.util.List;

public interface IUserService {
    public void addUser(UserDto userDto);
    public void deleteUser(int id);
    public List<UserDto> getAllUsers();
    public UserDto getUser(int id);
}
