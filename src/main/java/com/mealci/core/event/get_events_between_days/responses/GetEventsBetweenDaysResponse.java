package com.mealci.core.event.get_events_between_days.responses;

import java.util.Date;
import java.util.Map;

public record GetEventsBetweenDaysResponse(Map<Date, GetEventsBetweenDaysResponseEvent> events) {}
