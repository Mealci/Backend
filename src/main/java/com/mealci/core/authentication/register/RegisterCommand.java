package com.mealci.core.authentication.register;

import an.awesome.pipelinr.Command;

public record RegisterCommand(RegisterRequest request) implements Command<String> {}
