package com.mealci.dal.food.repositories;

import com.mealci.dal.food.FoodEntity;
import com.mealci.dal.users.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface FoodRepository extends JpaRepository<FoodEntity, Long> {
    List<FoodEntity> findByUser(UserEntity user);
    List<FoodEntity> findByCreateAtBetween(Instant from, Instant to);
}
