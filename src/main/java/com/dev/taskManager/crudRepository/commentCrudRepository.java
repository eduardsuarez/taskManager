package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface commentCrudRepository extends JpaRepository<Comment, Integer> {

}
