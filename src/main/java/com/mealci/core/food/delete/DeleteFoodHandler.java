package com.mealci.core.food.delete;

import an.awesome.pipelinr.Command;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import org.springframework.stereotype.Component;

@Component
public class DeleteFoodHandler implements Command.Handler<DeleteFoodCommand, Void> {
    private final CustomFoodRepository customFoodRepository;

    public DeleteFoodHandler(CustomFoodRepository customFoodRepository) {
        this.customFoodRepository = customFoodRepository;
    }

    @Override
    public Void handle(DeleteFoodCommand deleteFoodCommand) {
        customFoodRepository.deleteFood(deleteFoodCommand.id());

        return null;
    }
}
