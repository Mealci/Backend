package com.mealci.core.food;

import com.mealci.core.food.create.CreateFoodRequest;
import com.mealci.core.results.Result;
import com.mealci.core.users.UserService;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import org.springframework.stereotype.Service;

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
    public Result<Food> create(CreateFoodRequest request) {
        var user = userService.getCurrentUser();
        if (!user.isSuccess()) {
            return Result.failure(user.getErrorCode());
        }

        var food = Food.create(
                request.name(),
                request.category(),
                request.quantity(),
                request.measure(),
                request.brand(),
                user.getValue());

        var email = user.getValue().email.address;
        var createFood = customFoodRepository.create(food, email);

        return Result.success(createFood);
    }
}
