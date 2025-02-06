package com.mealci.core.food_category;

import lombok.Getter;

@Getter
public enum FoodCategory {
    FRUITS(1),
    VEGETABLES(2),
    CEREALS(3),
    PROTEINS(4),
    DAIRY_PRODUCTS(5),
    STARCHY(6),
    OILS(7),
    SUGAR_PRODUCTS(8),
    BEVERAGE(9),
    SPICES(10),
    PREPARED_MEALS(11);

    private final int value;

    FoodCategory(int value)
    {
        this.value = value;
    }

    public static FoodCategory fromValue(int value) {
        for (FoodCategory foodCategory : FoodCategory.values()) {
            if (foodCategory.getValue() == value) {
                return foodCategory;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
