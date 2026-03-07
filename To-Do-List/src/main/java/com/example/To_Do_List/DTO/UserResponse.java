package com.example.To_Do_List.DTO;

import com.example.To_Do_List.Model.UserRole;
import lombok.*;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String email;
    private String name;
    private LocalDateTime date;
    private UserRole role;
}
