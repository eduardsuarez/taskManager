/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.controller;

import com.dev.taskManager.entity.Task;
import com.dev.taskManager.service.TaskService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduar
 */
@RestController
@RequestMapping("/api/task")
public class TaskController {
    @Autowired
    private TaskService taskService;
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Task create(@RequestBody Task task){
        return taskService.create(task);
    }
    
    @GetMapping("/{id}")
    public Optional<Task> getTaskById(@PathVariable("id") int id){
        return taskService.getTaskById(id);
    }
    @GetMapping("/all")
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Task update(@RequestBody Task task){
        return taskService.update(task);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return taskService.delete(id);
    }
    
}
