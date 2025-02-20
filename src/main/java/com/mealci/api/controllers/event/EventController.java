package com.mealci.api.controllers.event;

import com.mealci.api.configuration.entrypoints.OpenApiConfiguration;
import com.mealci.api.configuration.entrypoints.SecurityConfig;
import com.mealci.core.event.EventService;
import com.mealci.core.event.get_events_between.GetEventsBetweenResponse;
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
    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @SecurityRequirement(name = OpenApiConfiguration.BEARER_AUTH)
    @GetMapping("getBetween")
    public ResponseEntity<GetEventsBetweenResponse> getBetween(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date from,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date to) {
        var result = eventService.getEventsBetween(from, to);

        return ResponseEntity.ok(result);
    }
}
