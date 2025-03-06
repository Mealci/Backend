package com.mealci.core.dates;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DateHelper {
    public static List<Date> getDatesBetween(Date startDate, Date endDate) {
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

    public static Instant getStartOfDay(Date date) {
        return date.toInstant()
                .atZone(ZoneOffset.UTC)
                .toLocalDate()
                .atStartOfDay(ZoneOffset.UTC)
                .toInstant();
    }

    public static Instant getEndOfDay(Date date) {
        return date.toInstant()
                .atZone(ZoneOffset.UTC)
                .toLocalDate()
                .atStartOfDay(ZoneOffset.UTC)
                .plusDays(1)
                .minusNanos(1)
                .toInstant();
    }
}
