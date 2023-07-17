/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.projectCrudRepository;
import com.dev.taskManager.entity.Project;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class ProjectRepository {
     @Autowired
    private projectCrudRepository crudRepository;
    
    public Project create(Project project){
        return crudRepository.save(project);
    }
    
    public Optional<Project> findProjectById(int id){
        return crudRepository.findById(id);
    }
    
    public List<Project> findAllProjects(){
        return (List<Project>) crudRepository.findAll();
    }
    public Project update(Project project){
        return crudRepository.save(project);
        
    }
    public void delete(Project project) {
        crudRepository.delete(project);
        
    }
    
}
