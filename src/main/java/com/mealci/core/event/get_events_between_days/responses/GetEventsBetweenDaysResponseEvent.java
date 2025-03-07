package com.mealci.core.event.get_events_between_days.responses;

import java.util.List;

public record GetEventsBetweenDaysResponseEvent(List<GetEventsBetweenDaysResponseFood> foods,
                                                List<GetEventsBetweenDaysResponsePoop> poops) {}
