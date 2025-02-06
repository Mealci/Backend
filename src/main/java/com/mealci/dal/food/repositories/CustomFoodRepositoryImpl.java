package com.mealci.dal.food.repositories;

import com.mealci.core.exceptions.DalException;
import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.food.Food;
import com.mealci.core.food.get_foods.GetFoodResponse;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.food_state.FoodState;
import com.mealci.core.measure.Measure;
import com.mealci.core.users.User;
import com.mealci.dal.food.FoodEntity;
import com.mealci.dal.food.FoodProfile;
import com.mealci.dal.users.repositories.CustomUserRepository;
import com.mealci.dal.users.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomFoodRepositoryImpl implements CustomFoodRepository {
    private final FoodRepository foodRepository;
    private final CustomUserRepository customUserRepository;
    private final UserRepository userRepository;

    public CustomFoodRepositoryImpl(FoodRepository foodRepository,
                                    CustomUserRepository customUserRepository, UserRepository userRepository) {
        this.foodRepository = foodRepository;
        this.customUserRepository = customUserRepository;
        this.userRepository = userRepository;
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

    @Override
    public List<GetFoodResponse> getFoods(User user) {
        var entity = userRepository.findByEmail(user.email.address);
        if (entity.isEmpty()) {
            throw new NotFoundException("user not found");
        }

        var result = foodRepository.findByUser(entity.get());
        var foods = new ArrayList<GetFoodResponse>();
        for (var food : result) {
            var foodResponse = new GetFoodResponse(
                    food.getId(),
                    Food.create(food.getName(),
                            FoodCategory.fromValue(food.getCategory()),
                            food.getQuantity(),
                            Measure.fromValue(food.getMeasure()),
                            food.getBrand(),
                            FoodState.fromValue(food.getState())));
            foods.add(foodResponse);
        }

        return foods;
    }

    private FoodEntity setUser(Food food, String email) {
        var user = customUserRepository.getByEmail(email);
        var foodEntity = FoodProfile.toEntity(food);
        foodEntity.setUser(user);

        return foodEntity;
    }
}
