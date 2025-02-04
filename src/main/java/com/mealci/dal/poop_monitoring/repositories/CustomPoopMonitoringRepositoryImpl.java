package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.results.Result;
import com.mealci.dal.poop_monitoring.PoopMonitoringProfile;
import com.mealci.dal.users.UserRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CustomPoopMonitoringRepositoryImpl implements CustomPoopMonitoringRepository {
    private final PoopMonitoringRepository poopMonitoringRepository;
    private final UserRepository userRepository;

    public CustomPoopMonitoringRepositoryImpl(PoopMonitoringRepository poopMonitoringRepository,
                                              UserRepository userRepository) {
        this.poopMonitoringRepository = poopMonitoringRepository;
        this.userRepository = userRepository;
    }

    public Result<PoopMonitoring> create(PoopMonitoring poopMonitoring, String email) {
        var user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            return Result.failure("User not found");
        }

        var entity = PoopMonitoringProfile.toEntity(poopMonitoring);
        entity.setUser(user.get());

        try {
            poopMonitoringRepository.save(entity);
        } catch (Exception exception) {
            return Result.failure(exception.getMessage());
        }

        var result = PoopMonitoringProfile.toDomain(entity);
        return Result.success(result);
    }
}
