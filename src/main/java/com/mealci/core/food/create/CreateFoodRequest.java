package com.mealci.core.food.create;

import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.food_state.FoodState;
import com.mealci.core.measure.Measure;

public record CreateFoodRequest(String name,
                                FoodCategory category,
                                double quantity,
                                Measure measure,
                                String brand,
                                FoodState state,
                                String barcode) { }