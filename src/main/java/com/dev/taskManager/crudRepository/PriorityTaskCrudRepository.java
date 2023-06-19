package com.dev.taskManager.crudRepository;

import com.dev.taskManager.entity.PriorityTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriorityTaskCrudRepository extends JpaRepository<PriorityTask, Integer> {
}
