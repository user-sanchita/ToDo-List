package com.example.To_Do_List.Controller;

//import com.example.To_Do_List.Cache.CacheService;
import com.example.To_Do_List.DTO.To_Do_Request;
import com.example.To_Do_List.DTO.To_Do_Response;
import com.example.To_Do_List.Model.ToDoList;
import com.example.To_Do_List.Model.To_Do;
import com.example.To_Do_List.Service.To_Do_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class To_Do_Controller {
    @Autowired
    private To_Do_Service toDoService;
//    @Autowired
//    private CacheService cacheService;
    @PostMapping("/todo/register")
    public ResponseEntity<To_Do_Response>register(@Valid@RequestBody To_Do_Request request){
        return ResponseEntity.ok(toDoService.register(request));
    }
    @GetMapping("/getall")
    public List<To_Do> getAllTodos(@RequestParam(required = false,defaultValue = "0") int pageNo,
                                   @RequestParam(required = false,defaultValue = "5") int pageSize,
                                   @RequestParam(required = false,defaultValue = "takenTime") String sortBy,
                                   @RequestParam(required = false,defaultValue = "asc") String sortDir,
                                   @RequestParam(required = false) ToDoList searchName){
        Sort sort = null;
        if(sortDir.equalsIgnoreCase("ASC")) sort = Sort.by(sortBy).ascending();
        else sort = Sort.by(sortBy).descending();
        return toDoService.getAllTodos(PageRequest.of(pageNo,pageSize,sort),searchName);
    }
//    @GetMapping("/cachedata")
//    public void getCacheData(){
//        cacheService.printCacheContents("too");
//    }
}
