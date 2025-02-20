package com.mealci.core.event.get_events_between;

import java.util.Date;
import java.util.List;
import java.util.Map;

public record GetEventsBetweenResponse(Map<Date, List<GetEventesBetweenEvents>> events) {}
