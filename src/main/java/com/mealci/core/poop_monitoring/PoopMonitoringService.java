package com.mealci.core.poop_monitoring;

import com.mealci.core.poop_monitoring.create.CreatePoopMonitoringRequest;
import com.mealci.core.results.Result;

import java.util.List;

public interface PoopMonitoringService {
    Result<PoopMonitoring> create(CreatePoopMonitoringRequest request);
    PoopMonitoring delete(int id);
    List<PoopMonitoring> getByUserId(int id);
}
