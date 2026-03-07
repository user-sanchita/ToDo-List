package com.example.To_Do_List.DTO;


import com.example.To_Do_List.Model.UserRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {
    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;
    @NotBlank(message = "Password is required")
    private String password;
    private String name;
    private UserRole role;
}
