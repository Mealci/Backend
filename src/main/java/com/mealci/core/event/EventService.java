package com.mealci.core.event;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface EventService {
    Map<Date, List<Event>> getEventsByDays(List<Date> days);
}
