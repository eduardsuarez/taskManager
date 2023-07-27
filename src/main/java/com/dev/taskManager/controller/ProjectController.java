/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.controller;

import com.dev.taskManager.entity.Project;
import com.dev.taskManager.service.ProjectService;
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
@RequestMapping("/api/project")
public class ProjectController {
    
    @Autowired
    private ProjectService projectService;
    
    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Project create(@RequestBody Project project){
        return projectService.create(project);
    }
    
    @GetMapping("/{id}")
    public Optional<Project> getProjectById(@PathVariable("id") int id){
        return projectService.getUserById(id);
    }
    @GetMapping("/all")
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Project update(@RequestBody Project project){
        return projectService.update(project);
    }
    
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return projectService.delete(id);
    }
}
