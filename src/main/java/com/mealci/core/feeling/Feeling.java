package com.mealci.core.feeling;

import lombok.Getter;

@Getter
public enum Feeling {
    VERY_BAD(1),
    BAD(2),
    OK(3),
    GOOD(4),
    VERY_GOOD(5);

    private final int value;

    Feeling(int value)
    {
        this.value = value;
    }

    public static Feeling fromValue(int value) {
        for (Feeling feeling : Feeling.values()) {
            if (feeling.getValue() == value) {
                return feeling;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
