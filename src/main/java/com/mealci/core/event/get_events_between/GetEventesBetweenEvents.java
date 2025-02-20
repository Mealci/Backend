package com.mealci.core.event.get_events_between;

import com.mealci.core.food.Food;
import com.mealci.core.poop_monitoring.PoopMonitoring;

import java.util.List;

public record GetEventesBetweenEvents(List<Food> foods, List<PoopMonitoring> poops) {}
