package com.mealci.core.food;

import com.mealci.core.base.ValueObject;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.measure.Measure;
import lombok.Getter;

@Getter
public class Food extends ValueObject {
    public final String name;
    public final FoodCategory category;
    public final double quantity;
    public final Measure measure;
    public final String brand;

    private Food(String name,
                 FoodCategory category,
                 double quantity,
                 Measure measure,
                 String brand) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.measure = measure;
        this.brand = brand;
    }

    public static Food create(String name,
                              FoodCategory category,
                              double quantity,
                              Measure measure,
                              String brand) {
        return new Food(name,category,quantity,measure,brand);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%s%s%s%s", name, category, quantity, measure, brand);
    }
}
