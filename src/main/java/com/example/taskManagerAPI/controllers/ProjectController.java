package com.example.taskManagerAPI.controllers;

import com.example.taskManagerAPI.dtos.projectDto.ProjectDetailResponseDto;
import com.example.taskManagerAPI.dtos.projectDto.ProjectRequestDto;
import com.example.taskManagerAPI.dtos.projectDto.ProjectResponseDto;
import com.example.taskManagerAPI.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjectController {
    private final ProjectService service;
    public ProjectController (ProjectService service){
        this.service = service;
    }

    @GetMapping("/projects")
    public ResponseEntity<List<ProjectResponseDto>> list(){
        return ResponseEntity.ok(service.list());
    }

    @PostMapping("/projects")
    public ResponseEntity<ProjectResponseDto> createProject(@RequestBody ProjectRequestDto dto){
        ProjectResponseDto project = service.createProject(dto);
        return ResponseEntity.status(201).body(project);
    }

    @GetMapping("/projects/{id}")
    public ResponseEntity<ProjectResponseDto> searchProject(@PathVariable Long id){
        ProjectResponseDto project = service.searchProject(id);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/projects/{id}/activate")
    public ResponseEntity<ProjectResponseDto> activateProject(@PathVariable Long id){
        ProjectResponseDto project = service.activateProject(id);
        return ResponseEntity.ok(project);
    }

    @PutMapping("/projects/{id}/deactivate")
    public ResponseEntity<ProjectResponseDto> deactivateProject(@PathVariable Long id){
        ProjectResponseDto project = service.deactivateProject(id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/projects/{id}")
    public ResponseEntity<String> removeProject(@PathVariable Long id){
        String message = service.removeProject(id);
        return ResponseEntity.ok(message);
    }

    @GetMapping("/projects/{id}/details")
    public ResponseEntity<ProjectDetailResponseDto> searchProjectDetails(@PathVariable Long id){
        ProjectDetailResponseDto project = service.searchProjectDetails(id);
        return ResponseEntity.ok(project);
    }
}
