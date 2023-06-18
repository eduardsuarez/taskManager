/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.taskCrudRepository;
import com.dev.taskManager.entity.Task;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class TaskRepository {
    @Autowired
    private taskCrudRepository crudRepository;
    public Task create(Task task){
        return crudRepository.save(task);
    }
    
    public Optional<Task> findTaskById(int id){
        return crudRepository.findById(id);
    }
    
    public List<Task> findAllTasks(){
        return (List<Task>) crudRepository.findAll();
    }
    public Task update(Task task){
        return crudRepository.save(task);
        
    }
    public void delete(Task task) {
        crudRepository.delete(task);
        
    }
    
}
