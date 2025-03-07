package com.mealci.core.event.get_events_between_days.responses;

import com.mealci.core.food_state.FoodState;
import com.mealci.core.measure.Measure;

public record GetEventsBetweenDaysResponseFood(String name,
                                               double quantity,
                                               Measure measure,
                                               FoodState state) {}
