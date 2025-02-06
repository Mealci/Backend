package com.mealci.dal.food.repositories;

import com.mealci.core.exceptions.DalException;
import com.mealci.core.food.Food;
import com.mealci.dal.food.FoodProfile;
import com.mealci.dal.users.repositories.CustomUserRepository;
import org.springframework.stereotype.Repository;

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
        var user = customUserRepository.getByEmail(email);
        var foodEntity = FoodProfile.toEntity(food);
        foodEntity.setUser(user);

        try {
            var result = foodRepository.save(foodEntity);

            return FoodProfile.toDomain(result);
        } catch (Exception exception) {
            throw new DalException(exception.getMessage());
        }
    }
}
