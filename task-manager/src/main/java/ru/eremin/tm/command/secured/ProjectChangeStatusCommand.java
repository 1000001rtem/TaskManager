package ru.eremin.tm.command.secured;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.command.AbstractTerminalCommand;
import ru.eremin.tm.exeption.IncorrectDataException;
import ru.eremin.tm.model.dto.ProjectDTO;
import ru.eremin.tm.model.entity.enumerated.Status;
import ru.eremin.tm.model.service.ConsoleService;
import ru.eremin.tm.model.service.api.IProjectService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @autor av.eremin on 16.04.2019.
 */

@NoArgsConstructor
public class ProjectChangeStatusCommand extends AbstractTerminalCommand {

    @Override
    public String getName() {
        return "project_change_status";
    }

    @Override
    public String getDescription() {
        return "Change status of project";
    }

    @Override
    public void setSecured() {
        this.isSecured = true;
    }

    @Override
    public void execute() throws IncorrectDataException {
        @NotNull final IProjectService projectService = locator.getProjectService();
        @NotNull final ConsoleService consoleService = locator.getConsoleService();
        @NotNull final String projectId = consoleService.getStringFieldFromConsole("Project id");
        @NotNull final ProjectDTO projectDTO = projectService.findOne(projectId);
        if (projectDTO == null) {
            throw new IncorrectDataException("Wrong id");
        }
        @NotNull final List<Status> statuses = Arrays.stream(Status.values()).collect(Collectors.toList());
        statuses.forEach(System.out::println);
        @NotNull final String newStatus = consoleService.getStringFieldFromConsole("New status");
        for (final Status status : statuses) {
            if (status.getDisplayName().equalsIgnoreCase(newStatus)) projectDTO.setStatus(status);
        }
        if (!newStatus.equalsIgnoreCase(projectDTO.getStatus().getDisplayName())) {
            throw new IncorrectDataException("Wrong status");
        }
        projectService.update(projectDTO);
    }

}
