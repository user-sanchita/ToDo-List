package com.example.To_Do_List.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;
    @Column(unique = true)
    private String email;
    private String password;
    private String name;
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonIgnore
    private List<To_Do> ToDos;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private UserRole role = UserRole.USER;

}
