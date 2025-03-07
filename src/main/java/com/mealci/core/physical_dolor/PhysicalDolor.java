package com.mealci.core.physical_dolor;

import lombok.Getter;

@Getter
public enum PhysicalDolor {
    VERY_HIGH(1),
    HIGH(2),
    OK(3),
    LOW(4),
    VERY_LOW(5),
    NOTHING(6),
    UNKNOWN(7);

    private final int value;

    PhysicalDolor(int value) {
        this.value = value;
    }

    public static PhysicalDolor fromValue(int value) {
        for (PhysicalDolor physicalDolor : PhysicalDolor.values()) {
            if (physicalDolor.getValue() == value) {
                return physicalDolor;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
