package com.mealci.dal.food.repositories;

import com.mealci.core.food.Food;
import com.mealci.core.food.get_foods.GetFoodResponse;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.users.User;

import java.time.Instant;
import java.util.List;

public interface CustomFoodRepository {
    Food create(Food food, String email);
    List<Food> batchCreate(List<Food> foods, String email);
    Food patchFoodState(int id, int foodState);
    List<GetFoodResponse> getFoods(User user);
    List<Food> getFoodsBetween(Instant from, Instant to);
    List<GetFoodResponse> getFoodsByCategory(FoodCategory category, User user);
    Food deleteFood(int id);
    void patchFoodQuantity(int id, double quantity);
}
