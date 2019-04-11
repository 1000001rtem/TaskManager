package ru.eremin.tm.commands;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.bootstrap.Bootstrap;


/**
 * @autor av.eremin on 10.04.2019.
 */

public abstract class AbstractTerminalCommand {

    @NotNull
    protected Bootstrap bootstrap;

    public AbstractTerminalCommand(@NotNull final Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public abstract String getName();

    public abstract String getDescription();

    public abstract void execute();

}
