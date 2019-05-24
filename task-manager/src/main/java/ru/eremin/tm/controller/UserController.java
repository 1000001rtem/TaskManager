package ru.eremin.tm.controller;

import com.ocpsoft.pretty.faces.annotation.URLMapping;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import org.primefaces.event.RowEditEvent;
import ru.eremin.tm.api.IUserService;
import ru.eremin.tm.exeption.IncorrectDataException;
import ru.eremin.tm.model.dto.UserDTO;
import ru.eremin.tm.model.entity.enumerated.Role;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.Arrays;
import java.util.List;

/**
 * @autor Eremin Artem on 24.05.2019.
 */

@Getter
@Setter
@ViewScoped
@ManagedBean(name = "userController")
@URLMapping(
        id = "users",
        pattern = "/enter/admin/users",
        viewId = "/WEB-INF/views/enter/user-list-view.xhtml"
)
public class UserController {

    @ManagedProperty(value = "#{userService}")
    private IUserService userService;

    private List<UserDTO> users;

    @PostConstruct
    public void init() {
        refresh();
    }

    public List<Role> getRoles() {
        return Arrays.asList(Role.values());
    }

    public void deleteUser(@Nullable final String id) throws IncorrectDataException {
        userService.remove(id);
        refresh();
    }

    public void onRowEdit(@Nullable final RowEditEvent event) throws IncorrectDataException {
        if (event == null) return;
        @Nullable final UserDTO userDTO = (UserDTO) event.getObject();
        userService.update(userDTO);
        refresh();
    }

    public void onRowCancel() {
    }

    private void refresh() {
        users = userService.findAll();
    }

}