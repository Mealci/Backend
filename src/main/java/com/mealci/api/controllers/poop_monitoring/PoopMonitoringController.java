package com.mealci.api.controllers.poop_monitoring;

import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.poop_monitoring.PoopMonitoringService;
import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/poopMonitoring")
public class PoopMonitoringController {
    private final PoopMonitoringService poopMonitoringService;

    public PoopMonitoringController(PoopMonitoringService poopMonitoringService) {
        this.poopMonitoringService = poopMonitoringService;
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @PostMapping("create")
    public ResponseEntity<PoopMonitoring> create(@RequestBody CreatePoopMonitoringRequest request) {
        var result = poopMonitoringService.create(request);

        return ResponseEntity.ok(result);
    }
}
