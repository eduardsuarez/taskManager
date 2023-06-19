package com.dev.taskManager.service;

import com.dev.taskManager.entity.Comment;
import com.dev.taskManager.entity.Task;
import com.dev.taskManager.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repository;

    public Comment create(Comment comment) {
        return repository.create(comment);
    }

    public Optional<Comment> getCommentById(int id) {
        return repository.findCommentById(id);
    }

    public List<Comment> getAllComments() {
        return repository.findAllComments();
    }

    public Comment update(Comment comment) {
        if (comment.getId() != null) {
            Optional<Comment> comment1 = repository.findCommentById(comment.getId());
            if (!comment1.isEmpty()) {
                if (comment.getId() != null) {
                    comment1.get().setId(comment.getId());

                }
                if (comment.getContent() != null) {
                    comment1.get().setContent(comment.getContent());
                }
                if (comment.getCreationDate() != null) {
                    comment1.get().setCreationDate(comment.getCreationDate());
                }

                repository.update(comment1.get());
                return comment1.get();
            } else {
                return comment;
            }
        } else {
            return comment;
        }
    }

    public boolean delete(int id) {
        Optional<Comment> comment = getCommentById(id);
        if (comment.isEmpty()) {
            return false;
        } else {
            repository.delete(comment.get());
            return true;
        }
    }


}
