package com.example.taskManagerAPI.controllers;

import com.example.taskManagerAPI.dtos.taskDto.TaskRequestDto;
import com.example.taskManagerAPI.dtos.taskDto.TaskResponseDto;
import com.example.taskManagerAPI.models.Task;
import com.example.taskManagerAPI.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {
    private TaskService service;
    public TaskController (TaskService service){
        this.service = service;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskResponseDto>> list(){
        return ResponseEntity.ok(service.list());
    }

    @PostMapping("/tasks")
    public ResponseEntity<TaskResponseDto> createTask(@RequestBody TaskRequestDto dto){
        TaskResponseDto task = service.createTask(dto);
        return ResponseEntity.status(201).body(task);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskResponseDto> searchTask(@PathVariable Long id){
        TaskResponseDto task = service.searchTask(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/tasks/{id}/activate")
    public ResponseEntity<TaskResponseDto> activateTask(@PathVariable Long id){
        TaskResponseDto task = service.activateTask(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/tasks/{id}/deactivate")
    public ResponseEntity<TaskResponseDto> deactivateTask(@PathVariable Long id){
        TaskResponseDto task = service.deactivateTask(id);
        return ResponseEntity.ok(task);
    }

    @DeleteMapping("/task/{id}")
    public ResponseEntity<String> removeTask(@PathVariable Long id){
        String message = service.removeTask(id);
        return ResponseEntity.ok(message);
    }

    @PutMapping("/tasks/{id}/start")
    public ResponseEntity<TaskResponseDto> startTask(@PathVariable Long id){
        TaskResponseDto task = service.startTask(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("/tasks/{id}/complete")
    public ResponseEntity<TaskResponseDto> completeTask(@PathVariable Long id){
        TaskResponseDto task = service.completeTask(id);
        return ResponseEntity.ok(task);
    }

    @GetMapping("/tasks/project/{projectId}")
    public ResponseEntity<List<TaskResponseDto>> searchByProjectId(@PathVariable Long projectId){
        List<TaskResponseDto> list = service.searchByProjectId(projectId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/tasks/active")
    public ResponseEntity<List<TaskResponseDto>> searchByActive(@RequestParam boolean active){
        List<TaskResponseDto> list = service.searchByActive(active);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/tasks/status")
    public ResponseEntity<List<TaskResponseDto>> searchByStatus(@RequestParam Task.Status status){
        List<TaskResponseDto> list = service.searchByStatus(status);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/tasks/priority")
    public ResponseEntity<List<TaskResponseDto>> searchByPriority(@RequestParam Task.Priority priority){
        List<TaskResponseDto> list = service.searchByPriority(priority);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/tasks/deadline")
    public ResponseEntity<List<TaskResponseDto>> searchByDeadline(@RequestParam String deadline){
        List<TaskResponseDto> list = service.searchByDeadline(deadline);
        return ResponseEntity.ok(list);
    }
}
