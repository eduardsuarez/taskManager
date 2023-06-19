package com.dev.taskManager.repository;

import com.dev.taskManager.crudRepository.commentCrudRepository;
import com.dev.taskManager.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

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
