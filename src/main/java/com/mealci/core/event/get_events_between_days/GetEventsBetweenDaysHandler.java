package com.mealci.core.event.get_events_between_days;

import an.awesome.pipelinr.Command;
import com.mealci.core.dates.DateHelper;
import com.mealci.core.event.Event;
import com.mealci.core.event.EventService;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponse;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponseEvent;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponseFood;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponsePoop;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Component
public class GetEventsBetweenDaysHandler
        implements Command.Handler<GetEventsBetweenDaysQuery, GetEventsBetweenDaysResponse> {
    private final EventService eventService;

    public GetEventsBetweenDaysHandler(EventService eventService) {
        this.eventService = eventService;
    }

    @Override
    public GetEventsBetweenDaysResponse handle(GetEventsBetweenDaysQuery query) {
        var days = DateHelper.getDatesBetween(query.from(), query.to());
        var events = eventService.getEventsByDays(days);

        return new GetEventsBetweenDaysResponse(getEventsResponse(events));
    }

    private static TreeMap<Date, GetEventsBetweenDaysResponseEvent> getEventsResponse(Map<Date, List<Event>> events) {
        var response = new TreeMap<Date, GetEventsBetweenDaysResponseEvent>();
        events.forEach((key, value) -> {
            var foods = getFoodsResponse(value);
            var poops = getPoopsResponse(value);
            response.put(key, new GetEventsBetweenDaysResponseEvent(foods, poops));
        });
        return response;
    }

    private static List<GetEventsBetweenDaysResponsePoop> getPoopsResponse(List<Event> value) {
        return value.stream()
                .flatMap(event -> event.poops.stream().map(poop -> new GetEventsBetweenDaysResponsePoop(
                        poop.stoolComposition,
                        poop.quantity)))
                .toList();
    }

    private static List<GetEventsBetweenDaysResponseFood> getFoodsResponse(List<Event> value) {
        return value.stream()
                .flatMap(event -> event.foods
                        .stream()
                        .map(food -> new GetEventsBetweenDaysResponseFood(
                                food.name,
                                food.quantity,
                                food.measure,
                                food.state)))
                .toList();
    }
}
