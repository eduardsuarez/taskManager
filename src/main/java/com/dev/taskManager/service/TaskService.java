/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.Task;
import com.dev.taskManager.repository.TaskRepository;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public Task create(Task task) {
        return taskRepository.create(task);
    }

    public Optional<Task> getTaskById(int id) {
        return taskRepository.findTaskById(id);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAllTasks();
    }

    public Task update(Task task) {
        if (task.getId() != null) {
            Optional<Task> taskDb = taskRepository.findTaskById(task.getId());
            if (!taskDb.isEmpty()) {
                if (task.getId() != null) {
                    taskDb.get().setId(task.getId());

                }
                if (task.getTitle() != null) {
                    taskDb.get().setTitle(task.getTitle());
                }
                if (task.getDescription() != null) {
                    taskDb.get().setDescription(task.getDescription());
                }
                if (task.getCreationDate() != null) {
                    taskDb.get().setCreationDate(task.getCreationDate());
                }
                if (task.getExpirationDate() != null) {
                    taskDb.get().setExpirationDate(task.getExpirationDate());
                }
                if (task.getCompleted() != null) {
                    taskDb.get().setCompleted(task.getCompleted());
                }
                taskRepository.update(taskDb.get());
                return taskDb.get();
            } else {
                return task;
            }
        } else {
            return task;
        }
    }

    public boolean delete(int id) {
        Optional<Task> task = getTaskById(id);
        if (task.isEmpty()) {
            return false;
        } else {
            taskRepository.delete(task.get());
            return true;
        }
    }

    public List<Task> reportTaskTime(String dateA, String dateB){
        LocalDate start;
        LocalDate end;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            start = LocalDate.parse(dateA, dateFormatter);
            end = LocalDate.parse(dateB, dateFormatter);
        } catch (DateTimeParseException e) {
            // Manejar la excepción de análisis de fecha
            e.printStackTrace();
            return Collections.emptyList();
        }

        if (start.isBefore(end)) {
            return taskRepository.findAllByCreationDateAndExpirationDate(Date.from(start.atStartOfDay(ZoneId.systemDefault()).toInstant()),
                    Date.from(end.atStartOfDay(ZoneId.systemDefault()).toInstant()));
        } else {
            return Collections.emptyList();
        }
    }
    
}
