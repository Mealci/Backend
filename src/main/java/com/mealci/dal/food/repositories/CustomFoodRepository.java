package com.mealci.dal.food.repositories;

import com.mealci.core.food.Food;

public interface CustomFoodRepository {
    Food create(Food food, String email);
}
