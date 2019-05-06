package ru.eremin.tm.client.command.secured;

import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import ru.eremin.tm.client.bootstrap.ServiceLocator;
import ru.eremin.tm.client.command.ICommand;
import ru.eremin.tm.server.endpoint.AccessForbiddenException_Exception;
import ru.eremin.tm.server.endpoint.AdminEndpoint;
import ru.eremin.tm.server.endpoint.AdminEndpointService;
import ru.eremin.tm.server.endpoint.IncorrectDataException_Exception;

import javax.inject.Inject;

/**
 * @autor av.eremin on 18.04.2019.
 */

@NoArgsConstructor
public class DataClearJSONCommand implements ICommand {

    @Inject
    private AdminEndpoint adminEndpoint;

    @Inject
    private ServiceLocator locator;

    @Override
    public String getName() {
        return "clear_json";
    }

    @Override
    public String getDescription() {
        return "Remove JSON file(for admin)";
    }

    @Override
    public boolean getSecured() {
        return true;
    }

    @Override
    public void execute() throws IncorrectDataException_Exception, AccessForbiddenException_Exception {
        adminEndpoint.clearJSON(locator.getSession());
    }

}
