/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.categoryTaskCrudRepository;
import com.dev.taskManager.entity.CategoryTask;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class CategoryTaskRepository {
    @Autowired
    private categoryTaskCrudRepository crudRepository;
    
    public CategoryTask create(CategoryTask categoryTask){
        return crudRepository.save(categoryTask);
    }
    
    public Optional<CategoryTask> findcategoryTaskById(int id){
        return crudRepository.findById(id);
    }
    
    public List<CategoryTask> findAllCategoryTasks(){
        return (List<CategoryTask>) crudRepository.findAll();
    }
    public CategoryTask update(CategoryTask categoryTask){
        return crudRepository.save(categoryTask);
        
    }
    public void delete(CategoryTask categoryTask) {
        crudRepository.delete(categoryTask);
        
    }
    
}
