package com.example.taskManagerAPI.dtos.projectDto;

public class ProjectRequestDto {
    private String name;
    private String description;
    private String deadline;

    public ProjectRequestDto(){

    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getName() {
        return name;
    }
}
