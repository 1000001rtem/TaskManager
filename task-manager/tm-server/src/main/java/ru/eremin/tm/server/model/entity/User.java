package ru.eremin.tm.server.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.server.model.entity.enumerated.Role;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @autor av.eremin on 11.04.2019.
 */

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user_table")
public class User extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = 7036583160470114038L;

    @Nullable
    @Column(name = "login", nullable = false, unique = true)
    private String login;

    @Nullable
    @Column(name = "hash_password", nullable = false)
    private String hashPassword;

    @Nullable
    @Column(name = "user_role")
    @Enumerated(value = EnumType.STRING)
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Project> projects;

}
