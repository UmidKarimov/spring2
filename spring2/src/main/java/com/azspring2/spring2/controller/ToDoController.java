package com.azspring2.spring2.controller;

import com.azspring2.spring2.entity.ToDoEntity;
import com.azspring2.spring2.exceptions.UserAlreadyExistsException;
import com.azspring2.spring2.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
public class ToDoController {

    @Autowired
    public ToDoService toDoService;


    @PostMapping
    public ResponseEntity addToDoTask (@RequestBody ToDoEntity task){
        try{
            toDoService.addToDoTask(task);
            return ResponseEntity.ok("Successfully added task!");
        }
        catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error while registering user");
        }
    }
}