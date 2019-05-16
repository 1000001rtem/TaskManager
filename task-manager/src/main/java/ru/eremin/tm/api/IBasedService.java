package ru.eremin.tm.api;

import org.jetbrains.annotations.Nullable;
import ru.eremin.tm.exeption.AccessForbiddenException;
import ru.eremin.tm.model.dto.AbstractDTO;
import ru.eremin.tm.model.entity.AbstractEntity;

import java.util.List;

/**
 * @autor av.eremin on 15.04.2019.
 */

public interface IBasedService<T extends AbstractEntity, E extends AbstractDTO> extends IService<T, E> {

    List<E> findByUserId(@Nullable String userId);

    void removeAll(@Nullable String userId) throws AccessForbiddenException;

    List<E> findAllSortedByCreateDate(@Nullable String userId) throws AccessForbiddenException;

    List<E> findAllSortedByStartDate(@Nullable String userId) throws AccessForbiddenException;

    List<E> findAllSortedByEndDate(@Nullable String userId) throws AccessForbiddenException;

    List<E> findAllSortedByStatus(@Nullable String userId) throws AccessForbiddenException;

    List<E> findByName(@Nullable String userId, @Nullable String name) throws AccessForbiddenException;

    List<E> findByDescription(@Nullable String userId, @Nullable String description) throws AccessForbiddenException;

}