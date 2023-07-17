/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.PriorityTask;
import com.dev.taskManager.repository.PriorityTaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class PriorityTaskService {
    @Autowired
    private PriorityTaskRepository repository;

    public PriorityTask create(PriorityTask priorityTask) {
        return repository.create(priorityTask);
    }

    public Optional<PriorityTask> getPriorityTaskById(int id) {
        return repository.findPriorityTaskById(id);
    }

    public List<PriorityTask> getAllLPriorityTasks() {
        return repository.findAllPriorityTasks();
    }

    public PriorityTask update(PriorityTask priorityTask) {
        if (priorityTask.getId() != null) {
            Optional<PriorityTask> priorityTask1 = repository.findPriorityTaskById(priorityTask.getId());
            if (!priorityTask1.isEmpty()) {
                if (priorityTask.getId() != null) {
                    priorityTask1.get().setId(priorityTask.getId());

                }
                if (priorityTask.getName() != null) {
                    priorityTask1.get().setName(priorityTask.getName());
                }

                repository.update(priorityTask1.get());
                return priorityTask1.get();
            } else {
                return priorityTask;
            }
        } else {
            return priorityTask;
        }
    }

    public boolean delete(int id) {
        Optional<PriorityTask> priorityTask = getPriorityTaskById(id);
        if (priorityTask.isEmpty()) {
            return false;
        } else {
            repository.delete(priorityTask.get());
            return true;
        }
    }
}
