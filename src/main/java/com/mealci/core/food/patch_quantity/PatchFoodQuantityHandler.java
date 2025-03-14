package com.mealci.core.food.patch_quantity;

import an.awesome.pipelinr.Command;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import org.springframework.stereotype.Component;

@Component
public class PatchFoodQuantityHandler implements Command.Handler<PatchFoodQuantityCommand, Void> {
    private final CustomFoodRepository customFoodRepository;

    public PatchFoodQuantityHandler(CustomFoodRepository customFoodRepository) {
        this.customFoodRepository = customFoodRepository;
    }

    @Override
    public Void handle(PatchFoodQuantityCommand command) {
        customFoodRepository.patchFoodQuantity(command.id(), command.quantity());

        return null;
    }
}
