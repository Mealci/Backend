package com.mealci.dal.food;

import com.mealci.core.food.Food;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.food_state.FoodState;
import com.mealci.core.measure.Measure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
                food.brand,
                food.state.getValue());
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
                FoodState.fromValue(entity.getState()));
    }

    public static List<Food> toDomain(List<FoodEntity> entities) {
        if (entities == null || entities.isEmpty()) {
            return Collections.emptyList();
        }

        var foodEntities = new ArrayList<Food>();
        for (FoodEntity entity : entities) {
            foodEntities.add(toDomain(entity));
        }

        return foodEntities;
    }
}
