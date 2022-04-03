package com.open.kanban.domain.service;

import com.open.kanban.adapters.database.entities.TaskData;

import java.util.List;

public interface TaskService {

    TaskData create(TaskData taskData);

    TaskData update(TaskData taskData);

    TaskData findById(Long id);

    List<TaskData> findAll();

    void deleteById(Long id);

    Boolean existsById(Long id);

    void changeStatus(Long taskId, String status);
}
