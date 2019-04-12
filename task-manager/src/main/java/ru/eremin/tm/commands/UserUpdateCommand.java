package ru.eremin.tm.commands;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.bootstrap.Bootstrap;
import ru.eremin.tm.model.dto.UserDTO;
import ru.eremin.tm.utils.ConsoleHelper;

/**
 * @autor av.eremin on 12.04.2019.
 */

public class UserUpdateCommand extends AbstractTerminalCommand {

    @NotNull
    private static final CommandEnum command = CommandEnum.USER_UPDATE;

    public UserUpdateCommand(@NotNull final Bootstrap bootstrap) {
        super(bootstrap);
    }

    @Override
    public String getName() {
        return command.getName();
    }

    @Override
    public String getDescription() {
        return command.getDescription();
    }

    @Override
    public void execute() {
        @NotNull final ConsoleHelper helper = new ConsoleHelper(bootstrap.getScanner());
        @NotNull final String newLogin = helper.getStringFieldFromConsole("New Login");
        @NotNull final UserDTO userDTO = bootstrap.getSession().getUser();
        userDTO.setLogin(newLogin);
        bootstrap.getUserService().update(userDTO);
        bootstrap.getSession().setUser(userDTO);
    }

}
