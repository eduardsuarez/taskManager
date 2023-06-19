package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.Label;
import org.springframework.data.jpa.repository.JpaRepository;

public interface labelCrudRepository extends JpaRepository<Label,Integer> {
}
