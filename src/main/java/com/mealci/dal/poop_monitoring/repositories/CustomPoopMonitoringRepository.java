package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.results.Result;

import java.time.Instant;

public interface CustomPoopMonitoringRepository {
    Result<Integer> countTodayPoopingNumber(String email, Instant now);
    Result<PoopMonitoring> create(PoopMonitoring poopMonitoring, String email);
}
