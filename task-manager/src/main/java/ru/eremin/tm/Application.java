package ru.eremin.tm;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.bootstrap.Bootstrap;
import ru.eremin.tm.command.secured.*;
import ru.eremin.tm.command.system.*;

public class Application {

    private static final Class[] CLASSES = {
            AboutCommand.class, HelpCommand.class, ExitCommand.class,
            AuthorizationCommand.class, UserRegistrationCommand.class,

            UserChangePasswordCommand.class, UserInfoCommand.class, UserUpdateCommand.class,

            TaskCreateCommand.class, TaskClearCommand.class, TaskInfoCommand.class,
            TaskRemoveCommand.class, TaskShowAllCommand.class, TaskShowInProjectCommand.class,
            TaskSortByCreateDateCommand.class, TaskSortByStartDateCommand.class, TaskSortByEndDateCommand.class,
            TaskSortByStatusCommand.class, TaskChangeStatusCommand.class, TaskFindByNameCommand.class,
            TaskFindByDescriptionCommand.class,

            ProjectCreateCommand.class, ProjectClearCommand.class, ProjectInfoCommand.class,
            ProjectRemoveCommand.class, ProjectShowAllCommand.class, ProjectSortByCreateDateCommand.class,
            ProjectSortByStartDateCommand.class, ProjectSortByEndDateCommand.class, ProjectSortByStatusCommand.class,
            ProjectChangeStatusCommand.class, ProjectFindByNameCommand.class, ProjectFindByDescriptionCommand.class,

            DataBeanLoadCommand.class, DataBeanSaveCommand.class, DataBeanClearCommand.class,
            DataSaveJaxbXMLCommand.class, DataLoadJaxbXMLCommand.class, DataClearXMLCommand.class,
            DataSaveJaxbJSONCommand.class, DataLoadJaxbJSONCommand.class, DataClearJSONCommand.class,
            DataSaveJacksonXMLCommand.class, DataLoadJacksonXMLCommand.class,
            DataSaveJacksonJSONCommand.class, DataLoadJacksonJSONCommand.class,

            LogoutCommand.class
    };

    public static void main(String[] args) {
        @NotNull final Bootstrap bootstrap = new Bootstrap();
        bootstrap.init(CLASSES);
    }

}
