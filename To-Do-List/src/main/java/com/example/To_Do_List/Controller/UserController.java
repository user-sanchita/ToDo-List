package com.example.To_Do_List.Controller;

import com.example.To_Do_List.DTO.LoginRequest;
import com.example.To_Do_List.DTO.LoginResponse;
import com.example.To_Do_List.DTO.UserRequest;
import com.example.To_Do_List.DTO.UserResponse;
import com.example.To_Do_List.Model.To_Do;
import com.example.To_Do_List.Model.User;
import com.example.To_Do_List.Security.JwtUtils;
import com.example.To_Do_List.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtUtils jwtUtils;
    @PostMapping("/auth/register")
    public ResponseEntity<UserResponse>register(@Valid@RequestBody UserRequest request){
        return ResponseEntity.ok(userService.register(request));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request){
        try{
            User user = userService.authenticate(request);
            String token = jwtUtils.generateToken(request.getEmail(),user.getRole().name());
            return ResponseEntity.ok(new LoginResponse(token));
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return ResponseEntity.status(401).build();
        }

    }
    @GetMapping("/get")
    public ResponseEntity<List<UserResponse>> getUser(@RequestHeader("Authorization")String token){
        return ResponseEntity.ok(userService.getUser());
    }

}
