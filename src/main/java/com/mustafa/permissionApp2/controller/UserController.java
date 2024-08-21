package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.services.user.IUserService;
import com.mustafa.permissionApp2.jpa.entities.User;
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
    public void addUser(User user) {
        userService.addUser(user);
    }


    @PostMapping("/delete")
    public void deleteUser(User user) {
        userService.deleteUser(user.getId());
    }

    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getUser(id);
    }

}
