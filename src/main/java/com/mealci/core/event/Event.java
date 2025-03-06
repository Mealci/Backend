package com.mealci.core.event;

import com.mealci.core.base.ValueObject;
import com.mealci.core.food.Food;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import lombok.Getter;

import java.util.List;

@Getter
public class Event extends ValueObject {
    public final List<Food> foods;
    public final List<PoopMonitoring> poops;

    private Event(List<Food> foods,
                  List<PoopMonitoring> poops) {
        this.foods = foods;
        this.poops = poops;
    }

    public static Event create(List<Food> foods,
                               List<PoopMonitoring> poops) {
        return new Event(foods, poops);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%s", foods, poops);
    }
}
