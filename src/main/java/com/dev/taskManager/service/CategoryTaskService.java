/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.CategoryTask;
import com.dev.taskManager.repository.CategoryTaskRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class CategoryTaskService {
     @Autowired
    private CategoryTaskRepository repository;
    
    public CategoryTask create(CategoryTask categoryTask) {
        return repository.create(categoryTask);
    }

    public Optional<CategoryTask> getCategoryTaskById(int id) {
        return repository.findcategoryTaskById(id);
    }

    public List<CategoryTask> getAllCategoryTasks() {
        return repository.findAllCategoryTasks();
    }

    public CategoryTask update(CategoryTask categoryTask) {
        if (categoryTask.getId() != null) {
            Optional<CategoryTask> categoryTaskDb = repository.findcategoryTaskById(categoryTask.getId());
            if (!categoryTaskDb.isEmpty()) {
                if (categoryTask.getId() != null) {
                    categoryTaskDb.get().setId(categoryTask.getId());

                }
                if (categoryTask.getName() != null) {
                    categoryTaskDb.get().setName(categoryTask.getName());
                }
                
                repository.update(categoryTaskDb.get());
                return categoryTaskDb.get();
            } else {
                return categoryTask;
            }
        } else {
            return categoryTask;
        }
    }

    public boolean delete(int id) {
        Optional<CategoryTask> categoryTask = getCategoryTaskById(id);
        if (categoryTask.isEmpty()) {
            return false;
        } else {
            repository.delete(categoryTask.get());
            return true;
        }
    }
}
