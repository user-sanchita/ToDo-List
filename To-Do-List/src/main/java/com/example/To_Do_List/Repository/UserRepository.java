package com.example.To_Do_List.Repository;

import com.example.To_Do_List.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    User findByEmail(String email);
}
