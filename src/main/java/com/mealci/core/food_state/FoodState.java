package com.mealci.core.food_state;

import lombok.Getter;

@Getter
public enum FoodState {
    PRESENT(1),
    EAT(2),
    DISCARD(3);

    private final int value;

    FoodState(int value)
    {
        this.value = value;
    }

    public static FoodState fromValue(int value) {
        for (FoodState foodState : FoodState.values()) {
            if (foodState.getValue() == value) {
                return foodState;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
