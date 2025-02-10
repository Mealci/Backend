package com.mealci.core.event;

import com.mealci.core.event.get_events_between.GetEventsBetweenResponse;

import java.util.Date;

public interface EventService {
    GetEventsBetweenResponse getEventsBetween(Date from, Date to);
}
