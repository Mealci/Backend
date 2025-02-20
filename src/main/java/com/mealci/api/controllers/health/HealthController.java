package com.mealci.api.controllers.health;

import an.awesome.pipelinr.Pipeline;
import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.core.health.patch_health_psychological_state.PatchHealthPsychologicalStateCommand;
import com.mealci.core.health.patch_health_psychological_state.PatchHealthPsychologicalStateRequest;
import com.mealci.core.health.patch_health_psychological_state.PatchHealthPsychologicalStateResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/health_monitoring")
public class HealthController {

    private final Pipeline pipeline;

    public HealthController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @PatchMapping(value = "psychologicalState")
    public ResponseEntity<PatchHealthPsychologicalStateResponse> patch(PatchHealthPsychologicalStateRequest request) {
        var result = new PatchHealthPsychologicalStateCommand(request).execute(pipeline);

        return ResponseEntity.ok(result);
    }
}
