package com.dev.taskManager.controller;

import com.dev.taskManager.entity.Comment;
import com.dev.taskManager.entity.Task;
import com.dev.taskManager.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    @Autowired
    private CommentService service;

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment create(@RequestBody Comment comment){
        return service.create(comment);
    }

    @GetMapping("/{id}")
    public Optional<Comment> getCommentById(@PathVariable("id") int id){
        return service.getCommentById(id);
    }
    @GetMapping("/all")
    public List<Comment> getAllComments(){
        return service.getAllComments();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Comment update(@RequestBody Comment comment){
        return service.update(comment);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return service.delete(id);
    }
}
