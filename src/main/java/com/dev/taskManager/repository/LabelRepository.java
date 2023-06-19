package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.labelCrudRepository;
import com.dev.taskManager.entity.Comment;
import com.dev.taskManager.entity.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
