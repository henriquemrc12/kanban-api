package com.open.kanban.adapters.database.repository;

import com.open.kanban.adapters.database.entities.TaskData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskData, Long> {
}
