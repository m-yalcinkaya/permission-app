package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.dto.UserDto;
import com.mustafa.permissionApp2.services.user.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserController {

    private IUserService userService;

    @PostMapping("/add")
    public void addUser(UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/delete")
    public void deleteUser(UserDto userDto) {
        userService.deleteUser(userDto.getId());
    }

    @GetMapping()
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

}
