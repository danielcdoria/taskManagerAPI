package com.example.taskManagerAPI.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String deadline;
    private boolean active;

    @OneToMany(mappedBy = "project")
    private List<Task> tasks;

    public Project(){

    }

    public Project(String name, String description, String deadline){
        if (name.isEmpty() || description.isEmpty() || deadline.isEmpty()){
            throw new IllegalArgumentException("The name, the description and the deadline can't be empty.");
        }
        this.name = name;
        this.description = description;
        this.deadline = deadline;
        this.active = true;
    }

    public void activate(){
        if (active){
            throw new IllegalArgumentException("The project is already active.");
        }
        this.active = true;
    }

    public void deactivate(){
        if (!active){
            throw new IllegalArgumentException("The project is already deactivated.");
        }
        this.active = false;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public String getDeadline() {
        return deadline;
    }

    public boolean isActive() {
        return active;
    }
}
