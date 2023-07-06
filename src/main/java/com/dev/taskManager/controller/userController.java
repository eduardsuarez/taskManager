/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.controller;

import com.dev.taskManager.entity.User;
import com.dev.taskManager.service.userService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/api/user")
public class userController {
    @Autowired
    private userService userService;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User saveUser(@RequestBody User user) {
        return userService.save(user);

    }
    
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable("id") int id) {
        return userService.getUserById(id);
    }
    @GetMapping("/name/{userName}")
    public Optional<User> findByName(@PathVariable("name") String name) {
        return userService.findByName(name);
    }


    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/page")
    public Page<User> findAllUsersPageable(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size ) {
        Pageable pageable = PageRequest.of(page, size);
        return userService.findAllUsersPageable(pageable);
    }


    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public  User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteUser(@PathVariable int id) {
        return userService.deleteUserById(id);
    }

    /*
    @GetMapping("/{email}/{password}")
    public User authnticatedUser(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.authenticateUser(email, password);
    }
    */
    
    
}
