package com.mealci.core.event.get_events_between_days.responses;

import com.mealci.core.stool_composition.StoolComposition;

public record GetEventsBetweenDaysResponsePoop(StoolComposition stoolComposition,
                                               int quantity) {}
