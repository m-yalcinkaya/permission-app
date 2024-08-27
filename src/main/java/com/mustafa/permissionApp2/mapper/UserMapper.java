package com.mustafa.permissionApp2.mapper;

import com.mustafa.permissionApp2.dto.UserDto;
import com.mustafa.permissionApp2.jpa.entities.User;

public class UserMapper {

    public static UserDto toUserDto(User user) {
        return new UserDto(
                user.getId(),
                user.getName(),
                user.getSurname(),
                user.getUsername(),
                user.getPassword(),
                user.getRole(),
                user.getRemainingDay(),
                user.getEmail()
        );
    }


    public static User toUser(UserDto userDto) {
        return new User(
                userDto.getId(),
                userDto.getName(),
                userDto.getSurname(),
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getRole(),
                userDto.getRemainingDay(),
                userDto.getEmail()
        );
    }
}
