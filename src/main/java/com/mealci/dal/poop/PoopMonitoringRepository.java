package com.mealci.dal.poop;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.List;

public interface PoopMonitoringRepository extends JpaRepository<PoopMonitoringEntity, Long> {

    List<PoopMonitoringEntity> findByUser_IdAndCreatedAt(
            int id,
            Instant startOfDay);

    default PoopMonitoring create(PoopMonitoring poopMonitoring, User user) {
        var entity = PoopMonitoringProfile.toEntity(poopMonitoring, user);
        var result = save(entity);

        return PoopMonitoringProfile.toDomain(result);
    }

    default int countPoopingNumber(int id, Instant now){
        return findByUser_IdAndCreatedAt(id, now).size();
    }

    default void save(PoopMonitoring poopMonitoring, User user) {
        var entity = PoopMonitoringProfile.toEntity(poopMonitoring, user);
        save(entity);
    }
}
