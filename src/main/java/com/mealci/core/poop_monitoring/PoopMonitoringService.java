package com.mealci.core.poop_monitoring;

import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;

public interface PoopMonitoringService {
    PoopMonitoring create(CreatePoopMonitoringRequest request);
}
