/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.statusTaskCrudRepository;
import com.dev.taskManager.entity.StatusTask;
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
    private statusTaskCrudRepository crudRepository;
    
    public StatusTask create(StatusTask statusTask){
        return crudRepository.save(statusTask);
    }
    
    public Optional<StatusTask> findStatusTaskById(int id){
        return crudRepository.findById(id);
    }
    
    public List<StatusTask> findAllStatusTasks(){
        return (List<StatusTask>) crudRepository.findAll();
    }
    public StatusTask update(StatusTask statusTask){
        return crudRepository.save(statusTask);
        
    }
    public void delete(StatusTask statusTask) {
        crudRepository.delete(statusTask);
        
    }
    
}
