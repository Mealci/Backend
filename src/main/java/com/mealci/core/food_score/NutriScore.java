package com.mealci.core.food_score;

import lombok.Getter;

@Getter
public enum NutriScore {
    NULL(0),
    A(1),
    B(2),
    C(3),
    D(4),
    E(5);

    private final int value;

    NutriScore(int value)
    {
        this.value = value;
    }

    public static NutriScore fromValue(int value) {
        for (NutriScore nutriScore : NutriScore.values()) {
            if (nutriScore.getValue() == value) {
                return nutriScore;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
