package ru.eremin.tm.client.command.secured;

import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.client.bootstrap.ServiceLocator;
import ru.eremin.tm.client.command.ICommand;
import ru.eremin.tm.server.endpoint.AccessForbiddenException_Exception;
import ru.eremin.tm.server.endpoint.IncorrectDataException_Exception;
import ru.eremin.tm.server.endpoint.ServerDTO;
import ru.eremin.tm.server.endpoint.ServerEndpoint;

import javax.inject.Inject;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * @autor av.eremin on 08.05.2019.
 */

public class ServerInfoCommand implements ICommand {

    @Inject
    private ServerEndpoint serverEndpoint;

    @Inject
    private ServiceLocator locator;

    @Override
    public String getName() {
        return "server_info";
    }

    @Override
    public String getDescription() {
        return "Show server information";
    }

    @Override
    public boolean getSecured() {
        return true;
    }

    @Override
    public void execute() throws IOException, ClassNotFoundException, JAXBException, IncorrectDataException_Exception, AccessForbiddenException_Exception {
        @Nullable final ServerDTO serverDTO = serverEndpoint.serverInfo(locator.getSession());
        System.out.println("Server host: " + serverDTO.getHost());
        System.out.println("Server port: " + serverDTO.getPort());
    }
}