package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;

public interface CustomPoopMonitoringRepository {
    PoopMonitoring create(PoopMonitoring poopMonitoring, String email);
}
