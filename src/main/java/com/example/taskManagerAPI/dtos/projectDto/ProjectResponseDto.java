package com.example.taskManagerAPI.dtos.projectDto;

public class ProjectResponseDto {
    private Long id;
    private String name;
    private String description;
    private String deadline;
    private boolean active;

    public ProjectResponseDto(Long id,
                              String name,
                              String description,
                              String deadline,
                              boolean active){
        this.id = id;
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.active = active;
    }

    public String getDescription() {
        return description;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getName() {
        return name;
    }

    public Long getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }
}
