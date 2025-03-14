package com.mealci.core.food.delete;

import an.awesome.pipelinr.Command;

public record DeleteFoodCommand(int id) implements Command<Void> {}
