package ru.eremin.tm.client;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.client.bootstrap.Bootstrap;
import ru.eremin.tm.client.command.secured.*;
import ru.eremin.tm.client.command.system.*;

/**
 * Hello world!
 */
public class Application {
    private static final Class[] CLASSES = {
            AboutCommand.class, HelpCommand.class, ExitCommand.class,
            AuthorizationCommand.class, UserRegistrationCommand.class,

            UserChangePasswordCommand.class, UserInfoCommand.class, UserUpdateCommand.class,

            TaskCreateCommand.class, TaskClearCommand.class, TaskInfoCommand.class,
            TaskRemoveCommand.class, TaskShowAllCommand.class, TaskShowInProjectCommand.class,
            TaskChangeStatusCommand.class, TaskFindByNameCommand.class, TaskFindByDescriptionCommand.class,
            TaskSortByStatusCommand.class, TaskSortByStartDateCommand.class, TaskSortByEndDateCommand.class,
            TaskSortByCreateDateCommand.class,

            ProjectCreateCommand.class, ProjectClearCommand.class, ProjectInfoCommand.class,
            ProjectRemoveCommand.class, ProjectShowAllCommand.class,
            ProjectChangeStatusCommand.class, ProjectFindByNameCommand.class, ProjectFindByDescriptionCommand.class,
            ProjectSortByCreateDateCommand.class, ProjectSortByStartDateCommand.class, ProjectSortByEndDateCommand.class,
            ProjectSortByStatusCommand.class,

            DataClearJSONCommand.class, DataSaveJacksonJSONCommand.class, DataLoadJacksonJSONCommand.class,

            LogoutCommand.class
    };

    public static void main(String[] args) {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        @NotNull final Thread thread = new Thread(bootstrap::closeSession);
        Runtime.getRuntime().addShutdownHook(thread);
        bootstrap.init(CLASSES);
    }
}