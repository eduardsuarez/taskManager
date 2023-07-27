/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.controller;

import com.dev.taskManager.entity.PriorityTask;
import com.dev.taskManager.service.PriorityTaskService;
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
@RequestMapping("/api/priorityTask")
public class PriorityTaskController {
    @Autowired
    private PriorityTaskService service;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public PriorityTask create(@RequestBody PriorityTask priorityTask){
        return service.create(priorityTask);
    }

    @GetMapping("/{id}")
    public Optional<PriorityTask> getPriorityTaskById(@PathVariable("id") int id){
        return service.getPriorityTaskById(id);
    }
    @GetMapping("/all")
    public List<PriorityTask> getAllPriorityTasks(){
        return service.getAllLPriorityTasks();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public PriorityTask update(@RequestBody PriorityTask priorityTask){
        return service.update(priorityTask);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }

}
