package com.example.taskManagerAPI.service;

import com.example.taskManagerAPI.dtos.projectDto.ProjectDetailResponseDto;
import com.example.taskManagerAPI.dtos.projectDto.ProjectRequestDto;
import com.example.taskManagerAPI.dtos.projectDto.ProjectResponseDto;
import com.example.taskManagerAPI.dtos.projectDto.ProjectTaskResponseDto;
import com.example.taskManagerAPI.models.Project;
import com.example.taskManagerAPI.repositories.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository repository;
    public ProjectService(ProjectRepository repository){
        this.repository = repository;
    }

    private Project searchEntity(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No project was found."));
    }

    private ProjectResponseDto convertToDto(Project project){
        return new ProjectResponseDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getDeadline(),
                project.isActive()
        );
    }

    private ProjectDetailResponseDto convertToDetail(Project project){
        List<ProjectTaskResponseDto> tasks = project.getTasks().stream()
                .map(task -> new ProjectTaskResponseDto(
                        task.getId(),
                        task.getTitle(),
                        task.getPriority(),
                        task.getStatus()
                )).toList();
        return new ProjectDetailResponseDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getDeadline(),
                project.isActive(),
                tasks
        );
    }

    public List<ProjectResponseDto> list(){
        List<Project> list = repository.findAll();
        return list.stream()
                .map(this::convertToDto)
                .toList();
    }

    public ProjectResponseDto createProject(ProjectRequestDto dto){
        if (dto == null){
            throw new IllegalArgumentException("The project can not be empty.");
        }
        Project project = new Project(
                dto.getName(),
                dto.getDescription(),
                dto.getDeadline()
        );
        repository.save(project);
        return convertToDto(project);
    }

    public ProjectResponseDto searchProject(Long id){
        Project project = searchEntity(id);
        return convertToDto(project);
    }

    public ProjectResponseDto activateProject(Long id){
        Project project = searchEntity(id);
        project.activate();
        repository.save(project);
        return convertToDto(project);
    }

    public ProjectResponseDto deactivateProject(Long id){
        Project project = searchEntity(id);
        project.deactivate();
        repository.save(project);
        return convertToDto(project);
    }

    public String removeProject(Long id){
        Project project = searchEntity(id);
        repository.delete(project);
        return "The project was removed successfully!";
    }

    public ProjectDetailResponseDto searchProjectDetails(Long id){
        Project project = searchEntity(id);
        return convertToDetail(project);
    }
}
