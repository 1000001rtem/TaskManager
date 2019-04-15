package ru.eremin.tm.model.entity.enumerated;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @autor av.eremin on 15.04.2019.
 */

@Getter
public enum Status {

    PLANNED("ЗАПЛАНИРОВАНО"),
    DURING("В ПРОЦЕССЕ"),
    DONE("ГОТОВО");

    @NotNull
    private String displayName;

    Status(@NotNull final String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}