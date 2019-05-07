package ru.eremin.tm.client.command.secured;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.client.bootstrap.ServiceLocator;
import ru.eremin.tm.client.command.ICommand;
import ru.eremin.tm.client.service.ConsoleService;
import ru.eremin.tm.server.endpoint.AccessForbiddenException_Exception;
import ru.eremin.tm.server.endpoint.IncorrectDataException_Exception;
import ru.eremin.tm.server.endpoint.ProjectDTO;
import ru.eremin.tm.server.endpoint.ProjectEndpoint;

import javax.inject.Inject;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @autor av.eremin on 10.04.2019.
 */

@NoArgsConstructor
public class ProjectCreateCommand implements ICommand {


    @Inject
    private ProjectEndpoint projectEndpoint;

    @Inject
    private ServiceLocator locator;

    @Inject
    private ConsoleService consoleService;

    @Override
    public String getName() {
        return "project_create";
    }

    @Override
    public String getDescription() {
        return "Create new project";
    }

    @Override
    public boolean getSecured() {
        return true;
    }

    @Override
    public void execute() throws IncorrectDataException_Exception, AccessForbiddenException_Exception {
        @NotNull final ProjectDTO projectDTO = getProject();
        projectEndpoint.persistProject(locator.getSession(), projectDTO);
    }

    @NotNull
    private ProjectDTO getProject() {
        @NotNull final String name = consoleService.getStringFieldFromConsole("Project name");
        @NotNull final String description = consoleService.getStringFieldFromConsole("Project Description");
        @Nullable final XMLGregorianCalendar startDate = consoleService.getDateFieldFromConsole("Start date");
        @Nullable final XMLGregorianCalendar endDate = consoleService.getDateFieldFromConsole("End date");
        @NotNull final ProjectDTO project = new ProjectDTO();
        project.setName(name);
        project.setDescription(description);
        if (startDate != null) project.setStartDate(startDate);
        if (endDate != null) project.setEndDate(endDate);
        project.setUserId(locator.getSession().getUserId());
        return project;
    }

}
