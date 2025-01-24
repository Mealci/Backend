package com.mealci.api.controllers.poop_monitoring;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.poop_monitoring.PoopMonitoringService;
import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import com.mealci.core.results.Result;
import com.mealci.core.stool_composition.StoolComposition;
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

    @PostMapping("create")
    public ResponseEntity<Result<PoopMonitoring>> cerate(@RequestBody CreatePoopMonitoringRequest request) {
        var result = poopMonitoringService.create(request);
        if (!result.isSuccess()) {
            return ResponseEntity.badRequest().body(result);
        }

        return ResponseEntity.ok(result);
    }
}
