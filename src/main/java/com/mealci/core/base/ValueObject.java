package com.mealci.core.base;

import java.util.Objects;

public abstract class ValueObject {
    protected abstract String toStringAttributes();

    public boolean valueEquals(ValueObject other) {
        return this == other || Objects.equals(this.toStringAttributes(), other.toStringAttributes());
    }
}
