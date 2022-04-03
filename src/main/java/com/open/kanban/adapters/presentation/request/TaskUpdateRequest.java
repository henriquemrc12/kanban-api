package com.open.kanban.adapters.presentation.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TaskUpdateRequest {

    private Long id;

    private String title;

    private String description;

    private String status;

}
