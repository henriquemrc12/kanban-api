package com.open.kanban.adapters.presentation.mapper;

import com.open.kanban.adapters.database.entities.TaskData;
import com.open.kanban.adapters.enums.TaskStatus;
import com.open.kanban.adapters.presentation.request.TaskCreateRequest;
import com.open.kanban.adapters.presentation.request.TaskUpdateRequest;

import java.time.LocalDateTime;

public class TaskMapper {

    public static TaskData map(TaskCreateRequest request) {
        return TaskData.builder()
                .title(request.getTitle().trim())
                .description(request.getDescription().trim())
                .status(TaskStatus.valueOf(request.getStatus()))
                .updatedAt(LocalDateTime.now())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static TaskData map(TaskUpdateRequest request) {
        return TaskData.builder()
                .id(request.getId())
                .title(request.getTitle().trim())
                .description(request.getDescription().trim())
                .status(TaskStatus.valueOf(request.getStatus()))
                .build();
    }

}
