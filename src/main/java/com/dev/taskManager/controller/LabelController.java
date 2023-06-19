package com.dev.taskManager.controller;

import com.dev.taskManager.entity.Comment;
import com.dev.taskManager.entity.Label;
import com.dev.taskManager.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/label")
public class LabelController {
    @Autowired
    private LabelService service;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Label create(@RequestBody Label label){
        return service.create(label);
    }

    @GetMapping("/{id}")
    public Optional<Label> getLabelById(@PathVariable("id") int id){
        return service.getLabelById(id);
    }
    @GetMapping("/all")
    public List<Label> getAllLabels(){
        return service.getAllLabels();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Label update(@RequestBody Label label){
        return service.update(label);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
