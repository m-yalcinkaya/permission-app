package com.mustafa.permissionApp2.services.user;

import com.mustafa.permissionApp2.dto.UserDto;
import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.jpa.repositories.IUserDao;
import com.mustafa.permissionApp2.mapper.UserMapper;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
@Transactional
public class UserServiceImpl implements IUserService {

    private IUserDao userDao;

    @Override
    public void addUser(UserDto userDto) {
        User user = UserMapper.toUser(userDto);
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDao.deleteUser(id);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userDao.getAllUsers();
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(UserMapper.toUserDto(user));
        }
        return userDtos;
    }

    @Override
    public UserDto getUser(int id) {
        User user = userDao.getUser(id);
        return UserMapper.toUserDto(user);
    }
}

