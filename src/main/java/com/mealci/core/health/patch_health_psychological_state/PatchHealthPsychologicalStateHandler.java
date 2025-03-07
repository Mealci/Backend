package com.mealci.core.health.patch_health_psychological_state;

import an.awesome.pipelinr.Command;
import com.mealci.dal.health.repositories.CustomHealthRepository;
import org.springframework.stereotype.Component;

@Component
public class PatchHealthPsychologicalStateHandler
        implements Command.Handler<PatchHealthPsychologicalStateCommand, PatchHealthPsychologicalStateResponse> {
    private final CustomHealthRepository customHealthRepository;

    public PatchHealthPsychologicalStateHandler(CustomHealthRepository customHealthRepository) {
        this.customHealthRepository = customHealthRepository;
    }

    @Override
    public PatchHealthPsychologicalStateResponse handle(PatchHealthPsychologicalStateCommand command) {
        var request = command.request();
        var patch = customHealthRepository.patch(request.psychologicalState(), request.Id());

        return new PatchHealthPsychologicalStateResponse(patch.psychologicalState, patch.physicalDolor);
    }
}
