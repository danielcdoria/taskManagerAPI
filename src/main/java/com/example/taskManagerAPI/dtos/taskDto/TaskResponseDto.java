package com.example.taskManagerAPI.dtos.taskDto;

import com.example.taskManagerAPI.models.Task;

public class TaskResponseDto {
    private Long id;
    private String title;
    private String description;
    private Task.Priority priority;
    private Task.Status status;
    private boolean active;
    private Long projectId;
    private String projectName;
    private String projectDeadline;

    public TaskResponseDto(Long id,
                           String title,
                           String description,
                           Task.Priority priority,
                           Task.Status status,
                           boolean active,
                           Long projectId,
                           String projectName,
                           String projectDeadline){

        this.id = id;
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.status = status;
        this.active = active;
        this.projectId = projectId;
        this.projectName = projectName;
        this.projectDeadline = projectDeadline;
    }

    public String getDescription() {
        return description;
    }

    public Task.Priority getPriority() {
        return priority;
    }

    public Task.Status getStatus() {
        return status;
    }

    public Long getProjectId() {
        return projectId;
    }

    public String getTitle() {
        return title;
    }

    public String getProjectDeadline() {
        return projectDeadline;
    }

    public Long getId() {
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public boolean isActive() {
        return active;
    }
}


