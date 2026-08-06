package com.example.taskManagerAPI.dtos.taskDto;

import com.example.taskManagerAPI.models.Task;

public class TaskRequestDto {
    private String title;
    private String description;
    private Task.Priority priority;
    private Long projectId;

    public Long getProjectId() {
        return projectId;
    }

    public Task.Priority getPriority() {
        return priority;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}
