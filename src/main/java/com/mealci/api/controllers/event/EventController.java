package com.mealci.api.controllers.event;

import an.awesome.pipelinr.Pipeline;
import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.core.event.get_events_between_days.GetEventsBetweenDaysQuery;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/event")
public class EventController {
    private final Pipeline pipeline;

    public EventController(Pipeline pipeline) {
        this.pipeline = pipeline;
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @GetMapping("getBetweenDays")
    public ResponseEntity<GetEventsBetweenDaysResponse> getBetweenDays(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date from,
                                                                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date to) {
        var result = new GetEventsBetweenDaysQuery(from, to).execute(pipeline);

        return ResponseEntity.ok(result);
    }
}
