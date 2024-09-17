package com.mustafa.permissionApp2.controller;


import com.mustafa.permissionApp2.dto.AuthRequest;
import com.mustafa.permissionApp2.dto.CreateUserRequest;
import com.mustafa.permissionApp2.jpa.entities.User;
import com.mustafa.permissionApp2.services.JwtService;
import com.mustafa.permissionApp2.services.user.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    private final UserServiceImpl userService;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    public AuthController(UserServiceImpl userService, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    @GetMapping("/welcome")
    public String welcome() {
        return "Hello world! this is FOLKDEV";
    }

    @PostMapping("/generateToken")
    public String generateToken(@RequestBody AuthRequest authRequest) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authRequest.username(), authRequest.password()));
        if (authentication.isAuthenticated()) {
            jwtService.generateToken(authRequest.username());
        }
        log.info("invalid username or password");
        throw new UsernameNotFoundException("invalid username or password" + authRequest.username());
    }

    @PostMapping("/addNewUser")
    public User addUser(@RequestBody CreateUserRequest userDto) {
        return userService.createUser(userDto);
    }


    @GetMapping("/user")
    public String getUserString() {
        return "This is USER!";
    }


    @GetMapping("/admin")
    public String getAdminString() {
        return "This is ADMIN!";
    }
}
