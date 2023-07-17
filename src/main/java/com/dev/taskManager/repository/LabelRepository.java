/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.labelCrudRepository;
import com.dev.taskManager.entity.Label;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class LabelRepository {
    @Autowired
    private labelCrudRepository crudRepository;

    public Label create(Label label){
        return crudRepository.save(label);
    }

    public Optional<Label> findLabelById(int id){
        return crudRepository.findById(id);
    }

    public List<Label> findAllLabels(){
        return (List<Label>) crudRepository.findAll();
    }
    public Label update(Label label){
        return crudRepository.save(label);

    }
    public void delete(Label label) {
        crudRepository.delete(label);
    }
    
}
