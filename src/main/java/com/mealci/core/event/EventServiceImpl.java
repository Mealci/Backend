package com.mealci.core.event;

import com.mealci.core.event.get_events_between.GetEventesBetweenEvents;
import com.mealci.core.event.get_events_between.GetEventsBetweenResponse;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import com.mealci.dal.poop_monitoring.repositories.CustomPoopMonitoringRepository;
import org.springframework.stereotype.Service;

import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class EventServiceImpl implements EventService {
    private final CustomFoodRepository customFoodRepository;
    private final CustomPoopMonitoringRepository customPoopMonitoringRepository;

    public EventServiceImpl(CustomFoodRepository customFoodRepository,
                            CustomPoopMonitoringRepository customPoopMonitoringRepository) {
        this.customFoodRepository = customFoodRepository;
        this.customPoopMonitoringRepository = customPoopMonitoringRepository;
    }

    @Override
    public GetEventsBetweenResponse getEventsBetween(Date from, Date to) {
        var days = getDatesBetween(from, to);

        Map<Date, List<GetEventesBetweenEvents>> response = new TreeMap<>();
        var startOfDay = from.toInstant().atZone(ZoneOffset.UTC).toLocalDate().atStartOfDay(ZoneOffset.UTC);
        var endOfDay = startOfDay.plusDays(1).minusNanos(1);
        for (var day : days) {
            var foods = customFoodRepository.getFoodsBetween(startOfDay.toInstant(), endOfDay.toInstant());
            var poops = customPoopMonitoringRepository.getPoopMonitoringBetween(startOfDay.toInstant(), endOfDay.toInstant());
            var events = new ArrayList<GetEventesBetweenEvents>();
            events.add(new GetEventesBetweenEvents(foods, poops));
            response.put(day, events);
        }

        return new GetEventsBetweenResponse(response);
    }

    private static List<Date> getDatesBetween(Date startDate, Date endDate) {
        var dates = new ArrayList<Date>();
        var start = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        var end = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        while (!start.isAfter(end)) {
            Date date = Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
            dates.add(date);

            start = start.plusDays(1);
        }

        return dates;
    }
}
