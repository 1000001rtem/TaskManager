package ru.eremin.tm.model.service;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.model.dto.ProjectDTO;
import ru.eremin.tm.model.entity.Project;
import ru.eremin.tm.model.repository.api.IProjectRepository;
import ru.eremin.tm.model.service.api.IProjectService;
import ru.eremin.tm.model.service.api.ITaskService;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor Eremin Artem on 08.04.2019.
 */

public class ProjectService implements IProjectService {

    @Nullable
    private IProjectRepository projectRepository;

    @Nullable
    private ITaskService taskService;

    public ProjectService(@Nullable final IProjectRepository projectRepository, @Nullable final ITaskService taskService) {
        if (projectRepository == null || taskService == null) return;
        this.projectRepository = projectRepository;
        this.taskService = taskService;
    }

    @Override
    @NotNull
    public List<ProjectDTO> findAll() {
        return projectRepository.findAll()
                .stream()
                .map(ProjectDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    @Nullable
    public ProjectDTO findOne(@Nullable final String id) {
        if (id == null || id.isEmpty()) return null;
        @Nullable final Project project = projectRepository.findOne(id);
        if (project == null) return null;
        return new ProjectDTO(project);
    }

    @Override
    @NotNull
    public List<ProjectDTO> findByUserId(@Nullable final String userId) {
        if (userId == null || userId.isEmpty()) return Collections.emptyList();
        return projectRepository.findByUserId(userId)
                .stream()
                .map(ProjectDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public void persist(@Nullable final ProjectDTO projectDTO) {
        if (projectDTO == null) return;
        @NotNull final Project project = getEntity(projectDTO);
        projectRepository.persist(project);
    }

    @Override
    public void merge(@Nullable final ProjectDTO projectDTO) {
        if (projectDTO == null) return;
        @NotNull final Project project = getEntity(projectDTO);
        projectRepository.merge(project);
    }


    @Override
    public void update(@Nullable final ProjectDTO projectDTO) {
        if (projectDTO == null) return;
        @NotNull final Project project = getEntity(projectDTO);
        projectRepository.update(project);
    }

    @Override
    public boolean remove(@Nullable final String id) {
        if (id == null || id.isEmpty() || isExist(id)) return false;
        projectRepository.remove(id);
        taskService.removeAllTasksInProject(id);
        return true;
    }

    @Override
    public void removeAll() {
        projectRepository.removeAll();
        taskService.removeAll();
    }

    @Override
    public boolean isExist(@Nullable final String id) {
        if (id == null || id.isEmpty()) return true;
        return projectRepository.findOne(id) == null;
    }

    @Override
    @NotNull
    public Project getEntity(@NotNull final ProjectDTO projectDTO) {
        @NotNull final Project project = new Project();
        project.setId(projectDTO.getId());
        if (projectDTO.getName() != null && !projectDTO.getName().isEmpty()) project.setName(projectDTO.getName());
        if (projectDTO.getDescription() != null && !projectDTO.getDescription().isEmpty()) {
            project.setDescription(projectDTO.getDescription());
        }
        if (projectDTO.getStartDate() != null) project.setStartDate(projectDTO.getStartDate());
        if (projectDTO.getEndDate() != null) project.setEndDate(projectDTO.getEndDate());
        if (projectDTO.getUserId() != null && !projectDTO.getUserId().isEmpty()) {
            project.setUserId(projectDTO.getUserId());
        }
        return project;
    }

}
