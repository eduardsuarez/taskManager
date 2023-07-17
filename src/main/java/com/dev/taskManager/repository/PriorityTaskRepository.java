/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.priorityTaskCrudRepository;
import com.dev.taskManager.entity.PriorityTask;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class PriorityTaskRepository {
    @Autowired
    private priorityTaskCrudRepository crudRepository;

    public PriorityTask create(PriorityTask priorityTask){
        return crudRepository.save(priorityTask);
    }

    public Optional<PriorityTask> findPriorityTaskById(int id){
        return crudRepository.findById(id);
    }

    public List<PriorityTask> findAllPriorityTasks(){
        return (List<PriorityTask>) crudRepository.findAll();
    }
    public PriorityTask update(PriorityTask priorityTask){
        return crudRepository.save(priorityTask);

    }
    public void delete(PriorityTask priorityTask) {
        crudRepository.delete(priorityTask);
    }
    
}
