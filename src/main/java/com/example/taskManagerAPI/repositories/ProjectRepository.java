package com.example.taskManagerAPI.repositories;

import com.example.taskManagerAPI.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
