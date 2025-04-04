package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.food.get_foods.GetFoodResponse;
import com.mealci.core.food_category.FoodCategory;
import com.mealci.core.food_state.FoodState;
import com.mealci.core.users.UserService;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    private final UserService userService;
    private final CustomFoodRepository customFoodRepository;

    public FoodServiceImpl(UserService userService,
                           CustomFoodRepository customFoodRepository) {
        this.userService = userService;
        this.customFoodRepository = customFoodRepository;
    }

    @Override
    public Food create(CreateFoodRequest request) {
        var user = userService.getCurrentUser();
        var food = Food.create(
                request.name(),
                request.category(),
                request.quantity(),
                request.measure(),
                request.brand(),
                request.state(),
                request.barcode());

        var email = user.email.address;

        return customFoodRepository.create(food, email);
    }

    @Override
    public List<Food> batchCreate(List<CreateFoodRequest> request) {
        var user = userService.getCurrentUser();
        var foods = new ArrayList<Food>();
        for (var food : request) {
            var entity = Food.create(
                    food.name(),
                    food.category(),
                    food.quantity(),
                    food.measure(),
                    food.brand(),
                    food.state(),
                    food.barcode());

            foods.add(entity);
        }

        var email = user.email.address;

        return customFoodRepository.batchCreate(foods, email);
    }

    @Override
    public Food patchFoodState(int id, FoodState state) {
        return customFoodRepository.patchFoodState(id, state.getValue());
    }

    @Override
    public List<GetFoodResponse> getFoods() {
        var user = userService.getCurrentUser();

        return customFoodRepository.getFoods(user);
    }

    @Override
    public List<GetFoodResponse> getFoodsByCategory(FoodCategory category) {
        return customFoodRepository.getFoodsByCategory(category, userService.getCurrentUser());
    }
}
