package com.example.To_Do_List.Model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Time;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class To_Do {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ToDo_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id",nullable = false,foreignKey = @ForeignKey(name="fk_to_do_user"))
    @JsonIgnore
    private User user;

    @Enumerated(EnumType.STRING)
    private ToDoList todo;
    private Time takenTime;
}
