package com.mealci.core.event.get_events_between_days;

import an.awesome.pipelinr.Command;
import com.mealci.core.event.get_events_between_days.responses.GetEventsBetweenDaysResponse;

import java.util.Date;

public record GetEventsBetweenDaysQuery(Date from, Date to)
        implements Command<GetEventsBetweenDaysResponse> {}
