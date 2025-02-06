package com.mealci.core.food;

import com.mealci.core.base.ValueObject;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.measure.Measure;
import com.mealci.core.users.User;
import lombok.Getter;

@Getter
public class Food extends ValueObject {
    public final String name;
    public final FoodCategory category;
    public final double quantity;
    public final Measure measure;
    public final String brand;
    public final User user;

    private Food(String name,
                 FoodCategory category,
                 double quantity,
                 Measure measure,
                 String brand,
                 User user) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.measure = measure;
        this.brand = brand;
        this.user = user;
    }

    public static Food create(String name,
                              FoodCategory category,
                              double quantity,
                              Measure measure,
                              String brand,
                              User user) {
        return new Food(name,category,quantity,measure,brand, user);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%s%s%s%s", name, category, quantity, measure, brand);
    }
}
