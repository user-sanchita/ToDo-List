package com.example.To_Do_List.Service;

import com.example.To_Do_List.DTO.To_Do_Request;
import com.example.To_Do_List.DTO.To_Do_Response;
import com.example.To_Do_List.Model.ToDoList;
import com.example.To_Do_List.Model.To_Do;
import com.example.To_Do_List.Model.User;
import com.example.To_Do_List.Repository.To_Do_Repository;
import com.example.To_Do_List.Repository.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class To_Do_Service {
    @Autowired
    private To_Do_Repository toDoRepository;
    @Autowired
    private UserRepository userRepository;
    public @Nullable To_Do_Response register(@Valid To_Do_Request request) {
        User user = userRepository.findById(request.getUserID())
                .orElseThrow(()->new RuntimeException("Invalid User"+request.getUserID()));
        To_Do toDo = To_Do.builder()
                .takenTime(request.getTakenTime())
                .user(user)
                .todo(request.getTodo())
                .build();
        To_Do savedUser = toDoRepository.save(toDo);
        return mapToResponse(savedUser);
    }

    private @Nullable To_Do_Response mapToResponse(To_Do savedUser) {
        To_Do_Response toDoResponse = new To_Do_Response();
        toDoResponse.setToDo_id(savedUser.getToDo_id());
        toDoResponse.setUserID(savedUser.getUser().getId());
        toDoResponse.setTodo(savedUser.getTodo());
        toDoResponse.setTakenTime(savedUser.getTakenTime());
        return toDoResponse;
    }

    public List<To_Do> getAllTodos(Pageable pageable, ToDoList searchName) {
        if(searchName==null)  return toDoRepository.findAll(pageable).getContent();
        return toDoRepository.findByTodo(pageable,searchName).getContent();
    }
}
