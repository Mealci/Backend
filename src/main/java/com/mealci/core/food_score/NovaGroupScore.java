package com.mealci.core.food_score;

import lombok.Getter;

@Getter
public enum NovaGroupScore {
    NULL(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4);

    private final int value;

    NovaGroupScore(int value)
    {
        this.value = value;
    }

    public static NovaGroupScore fromValue(int value) {
        for (NovaGroupScore novaGroupScore : NovaGroupScore.values()) {
            if (novaGroupScore.getValue() == value) {
                return novaGroupScore;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
