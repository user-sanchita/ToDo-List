package com.example.To_Do_List.DTO;

import com.example.To_Do_List.Model.ToDoList;
import lombok.*;

import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class To_Do_Response {
    private Long ToDo_id;
    private String userID;
    private ToDoList todo;
    private Time takenTime;
}
