package com.mustafa.permissionApp2.controller;


import com.mustafa.permissionApp2.security.JwtAuthFilter;
import com.mustafa.permissionApp2.services.JwtService;
import com.mustafa.permissionApp2.services.user.UserServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("")
public class LoginController {

    private final UserServiceImpl userService;
    private final JwtService jwtService;

    private final BCryptPasswordEncoder passwordEncoder;


    public LoginController(UserServiceImpl userService, JwtAuthFilter jwtAuthFilter, JwtService jwtService, BCryptPasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("/login")
    public ModelAndView getLoginView(){
        return new ModelAndView("login");
    }

    @GetMapping("/login?error=true")
    public ModelAndView notFoundUser(){
        return new ModelAndView("usernotfound");
    }

    @PostMapping("/login")
    public ModelAndView handleLogin(@RequestParam("email") String email,
                                    @RequestParam("password") String password) {
        // Kullanıcı doğrulama işlemi
        boolean isValidUser = userService.authenticateUser(email, password);

        if (isValidUser) {
            // Başarılı giriş durumunda ana sayfaya yönlendirme
            return new ModelAndView("redirect:/home");
        } else {
            // Hatalı giriş durumunda login sayfasına dön ve hata mesajı ile geri dön
            ModelAndView mav = new ModelAndView("login");
            mav.addObject("errorMessage", "Invalid email or password");
            return mav;
        }
    }
}
