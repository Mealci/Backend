package com.mealci.core.measure;

import lombok.Getter;

@Getter
public enum Measure {
    LITER(1),
    KILOGRAM(2),
    PIECE(3);

    private final int value;

    Measure(int value)
    {
        this.value = value;
    }

    public static Measure fromValue(int value) {
        for (Measure measure : Measure.values()) {
            if (measure.getValue() == value) {
                return measure;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
