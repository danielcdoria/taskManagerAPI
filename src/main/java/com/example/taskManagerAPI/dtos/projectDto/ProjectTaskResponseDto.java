package com.example.taskManagerAPI.dtos.projectDto;

import com.example.taskManagerAPI.models.Task;

public class ProjectTaskResponseDto {
    private Long id;
    private String title;
    private Task.Priority priority;
    private Task.Status status;

    public ProjectTaskResponseDto(Long id,
                                  String title,
                                  Task.Priority priority,
                                  Task.Status status){

        this.id = id;
        this.title = title;
        this.priority = priority;
        this.status = status;
    }

    public Task.Priority getPriority() {
        return priority;
    }

    public Task.Status getStatus() {
        return status;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
