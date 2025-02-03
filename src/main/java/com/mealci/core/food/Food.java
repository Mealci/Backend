package com.mealci.core.food;

import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.measure.Measure;
import lombok.Getter;

@Getter
public class Food {
    public String name;
    public FoodCategory category;
    public double quantity;
    public Measure measure;
    public String brand;

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
}
