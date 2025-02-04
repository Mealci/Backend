package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.dal.poop_monitoring.PoopMonitoringEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface PoopMonitoringRepository extends JpaRepository<PoopMonitoringEntity, Long> {
    List<PoopMonitoringEntity> findByUserIdAndCreatedAtBetween(int id, Instant startOfDay, Instant endOfDay);
}
