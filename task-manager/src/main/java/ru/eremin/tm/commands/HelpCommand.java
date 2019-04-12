package ru.eremin.tm.commands;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.bootstrap.Bootstrap;
import ru.eremin.tm.commands.base.AbstractTerminalCommand;
import ru.eremin.tm.commands.base.CommandEnum;

/**
 * @autor av.eremin on 10.04.2019.
 */

public class HelpCommand extends AbstractTerminalCommand {

    @NotNull
    private static final CommandEnum command = CommandEnum.HELP;

    public HelpCommand(@NotNull final Bootstrap bootstrap) {
        super(bootstrap);
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
        for (final CommandEnum command : CommandEnum.values()) {
            System.out.println(command.getName() + ": " + command.getDescription());
        }
    }

}
