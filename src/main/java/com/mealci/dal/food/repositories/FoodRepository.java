package com.mealci.dal.food.repositories;

import com.mealci.dal.food.FoodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
}
