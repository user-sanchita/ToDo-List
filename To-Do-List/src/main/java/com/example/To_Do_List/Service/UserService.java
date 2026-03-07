package com.example.To_Do_List.Service;

import com.example.To_Do_List.DTO.LoginRequest;
import com.example.To_Do_List.DTO.UserRequest;
import com.example.To_Do_List.DTO.UserResponse;
import com.example.To_Do_List.Model.User;
import com.example.To_Do_List.Model.UserRole;
import com.example.To_Do_List.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public @Nullable UserResponse register(@Valid UserRequest request) {
        UserRole role = request.getRole()!=null?request.getRole():UserRole.USER;
        User user = User.builder()
                .email(request.getEmail())
                .name(request.getName())
                .role(request.getRole())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();
        User savedUser = userRepository.save(user);
        System.out.println(savedUser.getDate());
        return mapToResponse(savedUser);
    }

    private @Nullable UserResponse mapToResponse(User savedUser) {
        UserResponse response = new UserResponse();
         response.setName(savedUser.getName());
         response.setDate(savedUser.getDate());
         response.setId(savedUser.getId());
         response.setRole(savedUser.getRole());
         response.setEmail(savedUser.getEmail());
         return response;
    }


    public User authenticate(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail());
        if(user==null) throw new RuntimeException("Invalid Credentials");
        if(!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid Credentials");
        return user;
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }

}
