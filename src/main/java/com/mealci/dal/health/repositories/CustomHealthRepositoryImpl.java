package com.mealci.dal.health.repositories;

import com.mealci.core.email.Email;
import com.mealci.core.health.Health;
import com.mealci.core.psychological_state.PsychologicalState;
import com.mealci.dal.health.HealthEntity;
import com.mealci.dal.health.HealthProfile;
import com.mealci.dal.users.repositories.CustomUserRepository;
import org.springframework.stereotype.Repository;

import java.time.Instant;

@Repository
public class CustomHealthRepositoryImpl implements CustomHealthRepository {
    private final HealthRepository healthRepository;
    private final CustomUserRepository customUserRepository;

    public CustomHealthRepositoryImpl(
            HealthRepository healthRepository,
            CustomUserRepository customUserRepository) {
        this.healthRepository = healthRepository;
        this.customUserRepository = customUserRepository;
    }

    @Override
    public Health patch(PsychologicalState psychologicalState, int id) {
        var healthEntity = healthRepository.getReferenceById(id);
        healthEntity.setPsychologicalState(psychologicalState.getValue());
        healthRepository.save(healthEntity);

        var result = healthRepository.save(healthEntity);

        return HealthProfile.toDomain(result);
    }

    @Override
    public Health initilize(Email email) {
        var user = customUserRepository.getByEmail(email.address);
        var health = new HealthEntity(Instant.now(), 6, 7, user);
        var result = healthRepository.save(health);

        return HealthProfile.toDomain(result);
    }
}
