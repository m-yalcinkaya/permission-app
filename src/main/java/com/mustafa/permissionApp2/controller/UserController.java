package com.mustafa.permissionApp2.controller;

import com.mustafa.permissionApp2.dto.UserDto;
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
    public RedirectView addUser(@ModelAttribute UserDto userDto) {
        userService.addUser(userDto);
        return new RedirectView("/viewUsers");
    }

    @DeleteMapping("/users/api/delete")
    public ResponseEntity<Void> deleteUser(UserDto userDto) {
        userService.deleteUser(userDto.getId());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("users/api")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("users/api/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id) {
        UserDto user = userService.getUser(id);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/viewUsers")
    public ModelAndView viewAllUsers() {
        List<UserDto> users = userService.getAllUsers();
        ModelAndView mav = new ModelAndView("user-list");  // View adı
        mav.addObject("users", users);  // Model verisi
        return mav;
    }

    @GetMapping()
    public ModelAndView home() {
        return new ModelAndView("home");  // View adı
    }
}