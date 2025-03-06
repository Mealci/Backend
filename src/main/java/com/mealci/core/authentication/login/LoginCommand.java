package com.mealci.core.authentication.login;

import an.awesome.pipelinr.Command;

public record LoginCommand(LoginRequest request) implements Command<String> {}
