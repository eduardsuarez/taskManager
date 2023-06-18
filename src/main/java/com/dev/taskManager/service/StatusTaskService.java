/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.StatusTask;
import com.dev.taskManager.repository.StatusTaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class StatusTaskService {
    @Autowired
    private StatusTaskRepository repository;
    public StatusTask create(StatusTask statusTask) {
        return repository.create(statusTask);
    }

    public Optional<StatusTask> getStatusTaskById(int id) {
        return repository.findStatusTaskById(id);
    }

    public List<StatusTask> getAllStatusTasks() {
        return repository.findAllStatusTasks();
    }

    public StatusTask update(StatusTask statusTask) {
        if (statusTask.getId() != null) {
            Optional<StatusTask> statusTaskDb = repository.findStatusTaskById(statusTask.getId());
            if (!statusTaskDb.isEmpty()) {
                if (statusTask.getId() != null) {
                    statusTaskDb.get().setId(statusTask.getId());

                }
                if (statusTask.getName() != null) {
                    statusTaskDb.get().setName(statusTask.getName());
                }
                
                repository.update(statusTaskDb.get());
                return statusTaskDb.get();
            } else {
                return statusTask;
            }
        } else {
            return statusTask;
        }
    }

    public boolean delete(int id) {
        Optional<StatusTask> statusTask = getStatusTaskById(id);
        if (statusTask.isEmpty()) {
            return false;
        } else {
            repository.delete(statusTask.get());
            return true;
        }
    }
    
}
