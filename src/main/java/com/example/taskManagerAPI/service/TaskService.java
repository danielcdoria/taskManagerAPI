package com.example.taskManagerAPI.service;

import com.example.taskManagerAPI.dtos.taskDto.TaskRequestDto;
import com.example.taskManagerAPI.dtos.taskDto.TaskResponseDto;
import com.example.taskManagerAPI.models.Project;
import com.example.taskManagerAPI.models.Task;
import com.example.taskManagerAPI.repositories.ProjectRepository;
import com.example.taskManagerAPI.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository repository;
    private final ProjectRepository projectRepository;
    public TaskService(TaskRepository repository, ProjectRepository projectRepository){
        this.repository = repository;
        this.projectRepository = projectRepository;
    }

    private Task searchEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No task was found"));
    }

    private TaskResponseDto convertToDto(Task task){
        Project project = projectRepository.findById(task.getProject().getId())
                .orElseThrow(() -> new IllegalArgumentException("No project was found."));

        return new TaskResponseDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.getPriority(),
                task.getStatus(),
                task.isActive(),
                task.getProject().getId(),
                task.getProject().getName(),
                task.getProject().getDeadline()
        );
    }

    public List<TaskResponseDto> list(){
        List<Task> list = repository.findAll();
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public TaskResponseDto createTask(TaskRequestDto dto){
        if (dto == null){
            throw new IllegalArgumentException("The task can't be empty.");
        }
        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("No project was found"));
        if (!project.isActive()){
            throw new IllegalArgumentException("The project must be active.");
        }
        Task task = new Task(
                dto.getTitle(),
                dto.getDescription(),
                dto.getPriority()
        );
        task.setProject(project);
        repository.save(task);
        return convertToDto(task);
    }

    public TaskResponseDto searchTask(Long id){
        Task task = searchEntity(id);
        return convertToDto(task);
    }

    public TaskResponseDto activateTask(Long id){
        Task task = searchEntity(id);
        task.activate();
        repository.save(task);
        return convertToDto(task);
    }

    public TaskResponseDto deactivateTask(Long id){
        Task task = searchEntity(id);
        task.deactivate();
        repository.save(task);
        return convertToDto(task);
    }

    public String removeTask(Long id){
        Task task = searchEntity(id);
        repository.delete(task);
        return "The task was removed successfully!";
    }

    public TaskResponseDto startTask(Long id){
        Task task = searchEntity(id);
        task.startTask();
        repository.save(task);
        return convertToDto(task);
    }

    public TaskResponseDto completeTask(Long id){
        Task task = searchEntity(id);
        task.completeTask();
        repository.save(task);
        return convertToDto(task);
    }

    public List<TaskResponseDto> searchByProjectId(Long projectId){
        List<Task> list = repository.findByProjectId(projectId);
        if (list.isEmpty()){
            throw new IllegalArgumentException("This project was not found.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<TaskResponseDto> searchByActive(boolean active){
        List<Task> list = repository.findByActive(active);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no active task.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<TaskResponseDto> searchByStatus(Task.Status status){
        if (status == null){
            throw new IllegalArgumentException("The status can't be null.");
        }
        List<Task> list = repository.findByStatus(status);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no task in this status");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<TaskResponseDto> searchByPriority(Task.Priority priority){
        if (priority == null){
            throw new IllegalArgumentException("The priority can't be null.");
        }
        List<Task> list = repository.findByPriority(priority);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no task in this priority.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public List<TaskResponseDto> searchByDeadline(String deadline){
        if (deadline.isEmpty()){
            throw new IllegalArgumentException("The deadline can't be empty.");
        }
        List<Task> list = repository.findByProject_DeadLine(deadline);
        if (list.isEmpty()){
            throw new IllegalArgumentException("There is no task at this deadline.");
        }
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }


}
