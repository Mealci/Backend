package com.mealci.core.food_category;

import lombok.Getter;

@Getter
public enum FoodCategory {
    BEVERAGE(1),
    DAIRY_PRODUCTS(2),
    FRUITS(3),
    LEGUMES(4),
    VEGETABLES(5),
    STARCHY(6),
    SUGAR_PRODUCTS(7),
    SPICES(8),
    BUTTERFAT(9),
    FODMAPS(10),
    DIETS(11);

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
