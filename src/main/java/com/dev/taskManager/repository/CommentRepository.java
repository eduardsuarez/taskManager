/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.commentCrudRepository;
import com.dev.taskManager.entity.Comment;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author eduar
 */
@Repository
public class CommentRepository {
    @Autowired
    private commentCrudRepository crudRepository;

    public Comment create(Comment comment){
        return crudRepository.save(comment);
    }

    public Optional<Comment> findCommentById(int id){
        return crudRepository.findById(id);
    }

    public List<Comment> findAllComments(){
        return (List<Comment>) crudRepository.findAll();
    }
    public Comment update(Comment comment){
        return crudRepository.save(comment);

    }
    public void delete(Comment comment) {
        crudRepository.delete(comment);

    }
    
}
