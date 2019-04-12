package ru.eremin.tm.commands;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.bootstrap.Bootstrap;
import ru.eremin.tm.model.dto.UserDTO;
import ru.eremin.tm.utils.ConsoleHelper;
import ru.eremin.tm.utils.Utils;

/**
 * @autor av.eremin on 12.04.2019.
 */

public class UserChangePasswordCommand extends AbstractTerminalCommand {

    @NotNull
    private static final CommandEnum command = CommandEnum.USER_CHANGE_PASSWORD;

    public UserChangePasswordCommand(@NotNull final Bootstrap bootstrap) {
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
        @NotNull final String oldPassword = Utils.getHash(helper.getStringFieldFromConsole("Old Password"));
        if (!oldPassword.equals(bootstrap.getSession().getUser().getHashPassword())) {
            System.out.println("*** Wrong Password ***");
            return;
        }
        @NotNull final String newPassword = Utils.getHash(helper.getStringFieldFromConsole("New Password"));
        @NotNull final UserDTO userDTO = bootstrap.getSession().getUser();
        userDTO.setHashPassword(newPassword);
        bootstrap.getUserService().update(userDTO);
        bootstrap.getSession().setUser(userDTO);
        System.out.println("*** Complete ***");
    }

}
