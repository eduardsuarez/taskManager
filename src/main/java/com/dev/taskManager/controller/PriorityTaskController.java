package com.dev.taskManager.controller;


import com.dev.taskManager.entity.PriorityTask;
import com.dev.taskManager.service.PriorityTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
