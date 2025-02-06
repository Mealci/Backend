package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.exceptions.DalException;
import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.dal.poop_monitoring.PoopMonitoringProfile;
import com.mealci.dal.users.repositories.UserRepository;
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

    public PoopMonitoring create(PoopMonitoring poopMonitoring, String email) {
        var user = userRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new NotFoundException("user not found");
        }

        var entity = PoopMonitoringProfile.toEntity(poopMonitoring);
        entity.setUser(user.get());

        try {
            poopMonitoringRepository.save(entity);
        } catch (Exception exception) {
            throw new DalException(exception.getMessage());
        }

        return PoopMonitoringProfile.toDomain(entity);
    }
}
