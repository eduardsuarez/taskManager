/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author eduar
 */
public interface taskCrudRepository extends JpaRepository<Task, Integer> {
    public List<Task> findAllByCreationDateGreaterThanEqualAndExpirationDateLessThanEqual(Date start, Date end);
    
}
