package com.mealci.dal.poop_monitoring.repositories;

import com.mealci.core.exceptions.NotFoundException;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.dal.poop_monitoring.PoopMonitoringProfile;
import com.mealci.dal.users.repositories.UserRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.List;

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
        poopMonitoringRepository.save(entity);

        return PoopMonitoringProfile.toDomain(entity);
    }

    @Override
    public List<PoopMonitoring> getPoopMonitoringBetween(Instant from, Instant to) {
        var poops = poopMonitoringRepository.findByCreatedAtBetween(from, to);

        return PoopMonitoringProfile.toDomain(poops);
    }
}
