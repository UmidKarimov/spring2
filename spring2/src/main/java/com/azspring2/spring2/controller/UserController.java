package com.azspring2.spring2.controller;

import com.azspring2.spring2.entity.UserEntity;
import com.azspring2.spring2.exceptions.UserAlreadyExistsException;
import com.azspring2.spring2.exceptions.UserNotFoundException;
import com.azspring2.spring2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity registration (@RequestBody UserEntity user){
        try{
            userService.registration(user);
            return ResponseEntity.ok("Successfully registered!");
        }
        catch (UserAlreadyExistsException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error while registering user");
        }
    }

    @GetMapping
    public ResponseEntity getUserById (@RequestParam Long id){
        try{
            return ResponseEntity.ok(userService.getUserById(id));
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error while getting user by id");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser (@PathVariable Long id){
        try{
            return ResponseEntity.ok("User with id <" + userService.deleteUser(id) + "> successfully deleted!");
        }
        catch (UserNotFoundException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body("Error while deleting user");
        }
    }
}
