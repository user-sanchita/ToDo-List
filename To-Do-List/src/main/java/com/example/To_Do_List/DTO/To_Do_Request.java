package com.example.To_Do_List.DTO;

import com.example.To_Do_List.Model.ToDoList;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.sql.Time;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class To_Do_Request {
    @NotBlank(message = "UserId is required")
    private String userID;
    private ToDoList todo;
    private Time takenTime;
}
