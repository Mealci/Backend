package com.mealci.core.base;

import lombok.Getter;

import java.util.Objects;

@Getter
public class Entity<T> {
    public final T id;

    public Entity(T id) {
        this.id = id;
    }

    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()) {
            return false;
        }

        var entity = (Entity<?>) object;

        return Objects.equals(id, entity.id);
    }
}
