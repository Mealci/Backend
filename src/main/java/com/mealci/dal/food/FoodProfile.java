package com.mealci.dal.food;

import com.mealci.core.food.Food;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.measure.Measure;
import com.mealci.dal.users.UserProfile;

public class FoodProfile {
    private FoodProfile() {}

    public static FoodEntity toEntity(Food food) {
        if (food == null) {
            return null;
        }

        return new FoodEntity(
                food.name,
                food.category.getValue(),
                food.quantity,
                food.measure.getValue(),
                food.brand);
    }

    public static Food toDomain(FoodEntity entity) {
        if (entity == null) {
            return null;
        }

        return Food.create(
                entity.getName(),
                FoodCategory.fromValue(entity.getCategory()),
                entity.getQuantity(),
                Measure.fromValue(entity.getMeasure()),
                entity.getBrand(),
                UserProfile.toDomain(entity.getUser()));
    }
}
