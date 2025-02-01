package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.results.Result;
import com.mealci.dal.poop_monitoring.PoopMonitoringProfile;
import com.mealci.dal.users.UserRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public class CustomPoopMonitoringRepositoryImpl implements CustomPoopMonitoringRepository {
    private final PoopMonitoringRepository poopMonitoringRepository;
    private final UserRepository userRepository;

    public CustomPoopMonitoringRepositoryImpl(PoopMonitoringRepository poopMonitoringRepository,
                                              UserRepository userRepository) {
        this.poopMonitoringRepository = poopMonitoringRepository;
        this.userRepository = userRepository;
    }

    public Result<Integer> countTodayPoopingNumber(String email, Instant now) {
        var user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return Result.failure("User not found");
        }

        var poopMonitorings = poopMonitoringRepository.findByUserIdAndCreatedAtBetween(user.get().id, now, now);
        return Result.success(poopMonitorings.size());
    }

    public Result<PoopMonitoring> create(PoopMonitoring poopMonitoring, String email) {
        try {
            var user = userRepository.findByEmail(email);
            if (user.isEmpty()) {
                return Result.failure("User not found");
            }

            var entity = PoopMonitoringProfile.toEntity(poopMonitoring);
            entity.setUser(user.get());
            poopMonitoringRepository.save(entity);

            var result = PoopMonitoringProfile.toDomain(entity);
            return Result.success(result);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
