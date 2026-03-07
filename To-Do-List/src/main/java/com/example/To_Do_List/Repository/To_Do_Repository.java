package com.example.To_Do_List.Repository;

import com.example.To_Do_List.Model.ToDoList;
import com.example.To_Do_List.Model.To_Do;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface To_Do_Repository extends JpaRepository<To_Do,String> {

    Page<To_Do> findByTodo(Pageable pageable, ToDoList searchName);
}
