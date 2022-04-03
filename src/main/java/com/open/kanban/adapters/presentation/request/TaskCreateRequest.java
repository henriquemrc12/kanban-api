package com.open.kanban.adapters.presentation.request;

import com.open.kanban.adapters.enums.TaskStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskCreateRequest {

    private String title;

    private String description;

    private String status = TaskStatus.TO_DO.name();

}
