package com.example.taskManagerAPI.dtos.projectDto;

import java.util.List;

public class ProjectDetailResponseDto {
    private Long id;
    private String name;
    private String description;
    private String deadline;
    private boolean active;
    private List<ProjectTaskResponseDto> tasks;

    public ProjectDetailResponseDto(Long id,
                                    String name,
                                    String description,
                                    String deadline,
                                    boolean active,
                                    List<ProjectTaskResponseDto> tasks){

        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.active = active;
        this.tasks = tasks;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<ProjectTaskResponseDto> getTasks() {
        return tasks;
    }

    public boolean isActive() {
        return active;
    }

    public String getDeadline() {
        return deadline;
    }
}
