package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.services.user.IUserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
@RequestMapping()
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class UserController {

    private IUserService userService;

    @PostMapping("users/api/add")
    public RedirectView addUser(@ModelAttribute User userDto) {
        userService.addUser(userDto);
        return new RedirectView("/viewUsers");
    }

    @DeleteMapping("/users/api/delete")
    public ResponseEntity<Void> deleteUser(User userDto) {
        userService.deleteUser(userDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("users/api")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("users/api/{id}")
    public ResponseEntity<User> getUserById(@PathVariable int id) {
        User user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/viewUsers")
    public ModelAndView viewAllUsers() {
        List<User> users = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("user-list");  // View adı
        mav.addObject("users", users);  // Model verisi
        return mav;
    }

    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("home");  // View adı
    }
}