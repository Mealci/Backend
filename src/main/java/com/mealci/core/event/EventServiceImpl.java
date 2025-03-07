package com.mealci.core.event;

import com.mealci.core.dates.DateHelper;
import com.mealci.dal.food.repositories.CustomFoodRepository;
import com.mealci.dal.poop_monitoring.repositories.CustomPoopMonitoringRepository;
import org.springframework.stereotype.Service;

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
    public Map<Date, List<Event>> getEventsByDays(List<Date> days) {
        var response = new TreeMap<Date, List<Event>>();
        for (var day : days) {
            var startOfDay = DateHelper.getStartOfDay(day);
            var endOfDay = DateHelper.getEndOfDay(day);

            var foods = customFoodRepository.getFoodsBetween(startOfDay, endOfDay);
            var poops = customPoopMonitoringRepository.getPoopMonitoringBetween(startOfDay, endOfDay);

            var event = List.of(Event.create(foods, poops));
            response.put(day, event);
        }

        return response;
    }
}
