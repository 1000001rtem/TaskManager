package ru.eremin.tm.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.model.entity.enumerated.Status;

import java.io.Serializable;
import java.util.Date;

/**
 * @autor av.eremin on 11.04.2019.
 */

@Getter
@Setter
@NoArgsConstructor
public class BaseEntity extends AbstractEntity implements Serializable {

    private static final long serialVersionUID = -8258236348117530843L;

    @Nullable
    protected String name;

    @Nullable
    protected String description;

    @Nullable
    protected Date startDate;

    @Nullable
    protected Date endDate;

    @Nullable
    protected Status status;

    @Nullable
    protected String userId;

}
