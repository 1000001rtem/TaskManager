package ru.eremin.tm.commands;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.bootstrap.Bootstrap;
import ru.eremin.tm.bootstrap.ServiceLocator;
import ru.eremin.tm.commands.base.AbstractTerminalCommand;
import ru.eremin.tm.commands.base.CommandEnum;
import ru.eremin.tm.model.entity.session.Session;
import ru.eremin.tm.utils.ConsoleHelper;
import ru.eremin.tm.utils.Utils;

/**
 * @autor av.eremin on 12.04.2019.
 */

public class AuthorizationCommand extends AbstractTerminalCommand {

    @NotNull
    private static final CommandEnum command = CommandEnum.AUTHORIZATION;

    public AuthorizationCommand(@NotNull final ServiceLocator locator) {
        super(locator);
        this.isSecured = false;
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
        System.out.println("*** AUTHORIZATION ***");
        @NotNull final ConsoleHelper helper = new ConsoleHelper(locator.getScanner());
        @NotNull final String login = helper.getStringFieldFromConsole("Login");
        @NotNull final String hashPassword = Utils.getHash(helper.getStringFieldFromConsole("Password"));
        @Nullable final Session session = locator.getAuthService().login(login, hashPassword);
        if (session == null) System.out.println("*** Wrong login or password ***");
        else locator.setSession(session);
    }

}
