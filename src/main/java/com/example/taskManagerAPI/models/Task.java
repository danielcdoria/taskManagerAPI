package com.example.taskManagerAPI.models;

import jakarta.persistence.*;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Enumerated(EnumType.STRING)
    private Priority priority;
    @Enumerated(EnumType.STRING)
    private Status status;
    private boolean active;

    @ManyToOne
    private Project project;

    public enum Priority{
        LOW, MEDIUM, HIGH
    }

    public enum Status{
        PENDING, IN_PROGRESS, DONE
    }

    public Task(){

    }

    public Task(String title, String description, Priority priority){
        if (title.isEmpty() || description.isEmpty()){
            throw new IllegalArgumentException("The title and the description can't be empty.");
        }
        if (priority == null){
            throw new IllegalArgumentException("The priority can't be null.");
        }
        if (status == null){
            throw new IllegalArgumentException("The status can't be null.");
        }
        this.title = title;
        this.description = description;
        this.priority = priority;
        this.active = true;
    }

    public void activate(){
        if (active){
            throw new IllegalArgumentException("The task is already active.");
        }
        this.active = true;
    }

    public void deactivate(){
        if (!active){
            throw new IllegalArgumentException("The task is already deactivated.");
        }
        this.active =  false;
    }

    public void startTask(){
        if (status != Status.PENDING){
            throw new IllegalArgumentException("The task must be pending to start.");
        }
        this.status = Status.IN_PROGRESS;
    }

    public void completeTask(){
        if (status != Status.IN_PROGRESS){
            throw new IllegalArgumentException("The task must be in progress to complete.");
        }
        this.status = Status.DONE;
    }

    public String getDescription() {
        return description;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Status getStatus() {
        return status;
    }

    public Priority getPriority() {
        return priority;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public boolean isActive() {
        return active;
    }
}
