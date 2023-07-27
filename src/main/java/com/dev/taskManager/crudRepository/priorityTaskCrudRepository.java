/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.PriorityTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author eduar
 */
public interface priorityTaskCrudRepository extends JpaRepository<PriorityTask, Integer>{
    
}
