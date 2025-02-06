package com.mealci.dal.food.repositories;

import com.mealci.core.exceptions.DalException;
import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.food.Food;
import com.mealci.dal.food.FoodEntity;
import com.mealci.dal.food.FoodProfile;
import com.mealci.dal.users.repositories.CustomUserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomFoodRepositoryImpl implements CustomFoodRepository {
    private final FoodRepository foodRepository;
    private final CustomUserRepository customUserRepository;

    public CustomFoodRepositoryImpl(FoodRepository foodRepository,
                                    CustomUserRepository customUserRepository) {
        this.foodRepository = foodRepository;
        this.customUserRepository = customUserRepository;
    }

    @Override
    public Food create(Food food, String email) {
        var foodEntity = setUser(food, email);
        try {
            var result = foodRepository.save(foodEntity);

            return FoodProfile.toDomain(result);
        } catch (Exception exception) {
            throw new DalException(exception.getMessage());
        }
    }

    @Override
    public List<Food> batchCreate(List<Food> foods, String email) {
        var foodEntities = new ArrayList<FoodEntity>();
        for (var food : foods) {
            var foodEntity = setUser(food, email);
            foodEntities.add(foodEntity);
        }

        try {
            var result = foodRepository.saveAll(foodEntities);

            return FoodProfile.toDomain(result);
        } catch (Exception exception) {
            throw new DalException(exception.getMessage());
        }
    }

    @Override
    public Food patchFoodState(int id, int foodState) {
        var food = foodRepository.findById((long) id);
        if (food.isEmpty()) {
            throw new NotFoundException("food not found");
        }

        food.get().setState(foodState);

        var result = foodRepository.save(food.get());

        return FoodProfile.toDomain(result);
    }

    private FoodEntity setUser(Food food, String email) {
        var user = customUserRepository.getByEmail(email);
        var foodEntity = FoodProfile.toEntity(food);
        foodEntity.setUser(user);

        return foodEntity;
    }
}
