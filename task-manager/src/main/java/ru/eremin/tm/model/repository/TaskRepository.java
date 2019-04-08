package ru.eremin.tm.model.repository;

import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.model.entity.Task;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @autor Eremin Artem on 08.04.2019.
 */

public enum TaskRepository implements ITaskRepository {

    INSTANCE;

    private final Map<String, Task> tasks;

    TaskRepository() {
        this.tasks = new HashMap<>();
    }

    @Override
    public List<Task> findByProjectId(final String projectId) {
        if (projectId == null || projectId.isEmpty()) return Collections.emptyList();
        final List<Task> taskByProject = new ArrayList<>();
        for (final Task task : tasks.values()) {
            if (task.getProjectId().equals(projectId)) taskByProject.add(task);
        }
        return taskByProject;
    }

    @Override
    public List<Task> findAll() {
        return new ArrayList<>(tasks.values());
    }

    @Override
    @Nullable
    public Task findById(final String id) {
        if (id == null || id.isEmpty()) return null;
        return tasks.get(id);
    }

    @Override
    public void insert(final Task task) {
        if (task == null) return;
        tasks.put(task.getId(), task);
    }

    @Override
    public void update(final Task task) {
        if (task == null) return;
        if (tasks.get(task.getId()) == null) return;
        tasks.put(task.getId(), task);
    }

    @Override
    public void delete(final Task task) {
        if (task == null) return;
        tasks.remove(task.getId());
    }

    @Override
    public void deleteAll() {
        tasks.clear();
    }

}
