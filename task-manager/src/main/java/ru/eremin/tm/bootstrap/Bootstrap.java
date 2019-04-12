package ru.eremin.tm.bootstrap;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.commands.*;
import ru.eremin.tm.model.entity.session.Session;
import ru.eremin.tm.model.repository.ProjectRepository;
import ru.eremin.tm.model.repository.TaskRepository;
import ru.eremin.tm.model.repository.UserRepository;
import ru.eremin.tm.model.repository.api.IProjectRepository;
import ru.eremin.tm.model.repository.api.ITaskRepository;
import ru.eremin.tm.model.repository.api.IUserRepository;
import ru.eremin.tm.model.service.ProjectService;
import ru.eremin.tm.model.service.TaskService;
import ru.eremin.tm.model.service.UserService;
import ru.eremin.tm.model.service.api.IProjectService;
import ru.eremin.tm.model.service.api.ITaskService;
import ru.eremin.tm.model.service.api.IUserService;
import ru.eremin.tm.security.AuthService;
import ru.eremin.tm.security.IAuthService;
import ru.eremin.tm.security.IRegistrationService;
import ru.eremin.tm.security.RegistrationService;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @autor Eremin Artem on 08.04.2019.
 */

@Getter
public class Bootstrap {

    @NotNull
    private final IProjectService projectService;

    @NotNull
    private final ITaskService taskService;

    @NotNull
    private final IUserService userService;

    @NotNull
    private final IAuthService authService;

    @NotNull
    private final IRegistrationService registrationService;

    @NotNull
    private final Scanner scanner;

    @Nullable
    @Setter
    private Session session;

    @NotNull
    private final Map<String, AbstractTerminalCommand> commands;

    public Bootstrap() {
        this.scanner = new Scanner(System.in);
        @NotNull final IProjectRepository projectRepository = new ProjectRepository();
        @NotNull final ITaskRepository taskRepository = new TaskRepository();
        @NotNull final IUserRepository userRepository = new UserRepository();
        this.taskService = new TaskService(taskRepository);
        this.projectService = new ProjectService(projectRepository, this.taskService);
        this.userService = new UserService(userRepository);
        this.authService = new AuthService(userService);
        this.registrationService = new RegistrationService(userService);
        this.commands = new HashMap<>();
    }

    public void init() {
        initCommand();
        System.out.println("*** WELCOME TO TASK MANAGER ***");
        String answer;
        while (true) {
            answer = parseLine(scanner.nextLine());
            final AbstractTerminalCommand command = commands.get(answer);
            if (command == null) commands.get(CommandEnum.HELP.getName()).execute();
            else commands.get(answer).execute();
        }
    }

    private void initCommand() {
        final AbstractTerminalCommand helpCommand = new HelpCommand(this);
        final AbstractTerminalCommand exitCommand = new ExitCommand(this);
        final AbstractTerminalCommand projectCreateCommand = new ProjectCreateCommand(this);
        final AbstractTerminalCommand projectShowAllCommand = new ProjectShowAllCommand(this);
        final AbstractTerminalCommand projectInfoCommand = new ProjectInfoCommand(this);
        final AbstractTerminalCommand projectRemoveCommand = new ProjectRemoveCommand(this);
        final AbstractTerminalCommand projectClearCommand = new ProjectClearCommand(this);
        final AbstractTerminalCommand taskCreateCommand = new TaskCreateCommand(this);
        final AbstractTerminalCommand taskShowAllCommand = new TaskShowAllCommand(this);
        final AbstractTerminalCommand taskInfoCommand = new TaskInfoCommand(this);
        final AbstractTerminalCommand taskRemoveCommand = new TaskRemoveCommand(this);
        final AbstractTerminalCommand taskClearCommand = new TaskClearCommand(this);
        final AbstractTerminalCommand taskShowInProjectCommand = new TaskShowInProjectCommand(this);
        final AbstractTerminalCommand authorizationCommand = new AuthorizationCommand(this);
        final AbstractTerminalCommand userRegistrationCommand = new UserRegistrationCommand(this);

        commands.put(helpCommand.getName(), helpCommand);
        commands.put(exitCommand.getName(), exitCommand);
        commands.put(projectCreateCommand.getName(), projectCreateCommand);
        commands.put(projectShowAllCommand.getName(), projectShowAllCommand);
        commands.put(projectInfoCommand.getName(), projectInfoCommand);
        commands.put(projectRemoveCommand.getName(), projectRemoveCommand);
        commands.put(projectClearCommand.getName(), projectClearCommand);
        commands.put(taskCreateCommand.getName(), taskCreateCommand);
        commands.put(taskShowAllCommand.getName(), taskShowAllCommand);
        commands.put(taskInfoCommand.getName(), taskInfoCommand);
        commands.put(taskRemoveCommand.getName(), taskRemoveCommand);
        commands.put(taskClearCommand.getName(), taskClearCommand);
        commands.put(taskShowInProjectCommand.getName(), taskShowInProjectCommand);
        commands.put(authorizationCommand.getName(), authorizationCommand);
        commands.put(userRegistrationCommand.getName(), userRegistrationCommand);
    }


    @Nullable
    private String parseLine(@Nullable final String nextLine) {
        if (nextLine == null || nextLine.isEmpty()) return null;
        if (nextLine.startsWith(CommandEnum.HELP.toString())) return CommandEnum.HELP.toString();
        if (nextLine.startsWith(CommandEnum.EXIT.toString())) return CommandEnum.EXIT.toString();
        if (nextLine.startsWith(CommandEnum.PROJECT_CREATE.toString())) return CommandEnum.PROJECT_CREATE.toString();
        if (nextLine.startsWith(CommandEnum.PROJECT_LIST.toString())) return CommandEnum.PROJECT_LIST.toString();
        if (nextLine.startsWith(CommandEnum.PROJECT_INFO.toString())) return CommandEnum.PROJECT_INFO.toString();
        if (nextLine.startsWith(CommandEnum.PROJECT_REMOVE.toString())) return CommandEnum.PROJECT_REMOVE.toString();
        if (nextLine.startsWith(CommandEnum.PROJECT_CLEAR.toString())) return CommandEnum.PROJECT_CLEAR.toString();
        if (nextLine.startsWith(CommandEnum.TASK_CREATE.toString())) return CommandEnum.TASK_CREATE.toString();
        if (nextLine.startsWith(CommandEnum.TASK_LIST.toString())) return CommandEnum.TASK_LIST.toString();
        if (nextLine.startsWith(CommandEnum.TASK_INFO.toString())) return CommandEnum.TASK_INFO.toString();
        if (nextLine.startsWith(CommandEnum.TASK_IN_PROJECT.toString())) return CommandEnum.TASK_IN_PROJECT.toString();
        if (nextLine.startsWith(CommandEnum.TASK_REMOVE.toString())) return CommandEnum.TASK_REMOVE.toString();
        if (nextLine.startsWith(CommandEnum.TASK_CLEAR.toString())) return CommandEnum.TASK_CLEAR.toString();
        if (nextLine.startsWith(CommandEnum.AUTHORIZATION.toString())) return CommandEnum.AUTHORIZATION.toString();
        if (nextLine.startsWith(CommandEnum.USER_REGISTRATION.toString())) return CommandEnum.USER_REGISTRATION.toString();
        return null;
    }

}
