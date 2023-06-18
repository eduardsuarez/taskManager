/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dev.taskManager.service;

import com.dev.taskManager.entity.Project;
import com.dev.taskManager.repository.ProjectRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author eduar
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public Project create(Project project) {
        return projectRepository.create(project);
    }

    public Optional<Project> getUserById(int id) {
        return projectRepository.findProjectById(id);
    }

    public List<Project> getAllProjects() {
        return projectRepository.findAllProjects();
    }

    public Project update(Project project) {
        if (project.getId() != null) {
            Optional<Project> projectDb = projectRepository.findProjectById(project.getId());
            if (!projectDb.isEmpty()) {
                if (project.getId() != null) {
                    projectDb.get().setId(project.getId());

                }
                if (project.getName() != null) {
                    projectDb.get().setName(project.getName());
                }
                if (project.getDescription() != null) {
                    projectDb.get().setDescription(project.getDescription());
                }
                projectRepository.update(projectDb.get());
                return projectDb.get();
            } else {
                return project;
            }
        } else {
            return project;
        }
    }

    public boolean delete(int id) {
        Optional<Project> project = getUserById(id);
        if (project.isEmpty()) {
            return false;
        } else {
            projectRepository.delete(project.get());
            return true;
        }
    }

}
