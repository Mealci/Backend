package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.results.Result;

public interface CustomPoopMonitoringRepository {
    Result<PoopMonitoring> create(PoopMonitoring poopMonitoring, String email);
}
