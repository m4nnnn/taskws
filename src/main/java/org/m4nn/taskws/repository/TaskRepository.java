package org.m4nn.taskws.repository;

import org.m4nn.taskws.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
    
}
