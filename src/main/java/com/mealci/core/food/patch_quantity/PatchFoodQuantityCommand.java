package com.mealci.core.food.patch_quantity;

import an.awesome.pipelinr.Command;

public record PatchFoodQuantityCommand(int id, double quantity) implements Command<Void> {}
