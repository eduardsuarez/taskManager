package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.PriorityTaskCrudRepository;
import com.dev.taskManager.entity.PriorityTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class PriorityTaskRepository {
    @Autowired
    private PriorityTaskCrudRepository crudRepository;

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
