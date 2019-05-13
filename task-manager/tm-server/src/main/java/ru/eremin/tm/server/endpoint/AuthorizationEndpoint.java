package ru.eremin.tm.server.endpoint;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.eremin.tm.server.api.IAuthorizationEndpoint;
import ru.eremin.tm.server.api.ISessionService;
import ru.eremin.tm.server.exeption.AccessForbiddenException;
import ru.eremin.tm.server.exeption.IncorrectDataException;
import ru.eremin.tm.server.model.dto.ResultDTO;
import ru.eremin.tm.server.model.dto.SessionDTO;
import ru.eremin.tm.server.service.security.IAuthService;
import ru.eremin.tm.server.utils.PasswordHashUtil;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @autor av.eremin on 19.04.2019.
 */

@Component
@WebService
public class AuthorizationEndpoint implements IAuthorizationEndpoint {

    @Nullable
    @Autowired
    private IAuthService authService;

    @Nullable
    @Autowired
    private ISessionService sessionService;

    @Override
    @WebMethod
    public SessionDTO login(@Nullable final String login, @Nullable final String password) throws IncorrectDataException, AccessForbiddenException {
        @NotNull final SessionDTO session = authService.login(login, PasswordHashUtil.md5(password));
        if (sessionService.findByUserId(session.getUserId()) != null) {
            throw new AccessForbiddenException("Session exist");
        }
        session.setSign(sessionService.sign(session));
        sessionService.persist(session);
        return session;
    }

    @Override
    public ResultDTO logout(@Nullable final SessionDTO sessionDTO) throws AccessForbiddenException, IncorrectDataException {
        sessionValidate(sessionDTO);
        sessionService.remove(sessionDTO.getId());
        return new ResultDTO(true);
    }

    @Override
    @WebMethod(exclude = true)
    public void init(String port) {
        System.out.println("http://localhost:" + port + "/AuthorizationEndpoint?WSDL");
        Endpoint.publish("http://localhost:" + port + "/AuthorizationEndpoint", this);
    }

    public void sessionValidate(@Nullable final SessionDTO session) throws AccessForbiddenException, IncorrectDataException {
        if (session == null) throw new AccessForbiddenException();
        @Nullable final SessionDTO sessionDTO = sessionService.findOne(session.getId());
        if (sessionDTO == null) throw new AccessForbiddenException();
        if (session.getUserId() == null && !session.getUserId().isEmpty()) throw new AccessForbiddenException();
        if (session.getUserRole() == null) throw new AccessForbiddenException();
        if (!session.getSign().equals(sessionDTO.getSign())) throw new AccessForbiddenException();
    }

}
