package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public interface CustomPoopMonitoringRepository {
    PoopMonitoring create(PoopMonitoring poopMonitoring, String email);
    List<PoopMonitoring> getPoopMonitoringBetween(Instant from, Instant to);
}
