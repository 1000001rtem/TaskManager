package ru.eremin.tm.command.secured;

import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.command.AbstractTerminalCommand;

import java.io.File;

/**
 * @autor av.eremin on 17.04.2019.
 */

public class DataClearXMLCommand extends AbstractTerminalCommand {

    @Override
    public String getName() {
        return "clear_xml";
    }

    @Override
    public String getDescription() {
        return "Remove XML file";
    }

    @Override
    public void setSecured() {
        this.isSecured = true;
    }

    @Override
    public void execute() {
        @NotNull final String path = "documents/serialization/" + locator.getSession().getUser().getId();
        @NotNull final File file = new File(path + "/data.xml");
        file.delete();
    }

}
