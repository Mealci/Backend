package com.mealci.core.health.patch_health_psychological_state;

import an.awesome.pipelinr.Command;

public record PatchHealthPsychologicalStateCommand(PatchHealthPsychologicalStateRequest request)
        implements Command<PatchHealthPsychologicalStateResponse> {}
