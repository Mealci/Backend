package com.mealci.dal.health.repositories;

import com.mealci.core.health.Health;
import com.mealci.core.psychological_state.PsychologicalState;
import com.mealci.dal.health.HealthProfile;
import org.springframework.stereotype.Repository;

@Repository
public class CustomHealthRepositoryImpl implements CustomHealthRepository {
    private final HealthRepository healthRepository;

    public CustomHealthRepositoryImpl(HealthRepository healthRepository) {
        this.healthRepository = healthRepository;
    }

    @Override
    public Health patch(PsychologicalState psychologicalState, int id) {
        var healthEntity = healthRepository.getReferenceById(id);
        healthEntity.setPsychologicalState(psychologicalState.getValue());
        healthRepository.save(healthEntity);

        var result = healthRepository.save(healthEntity);

        return HealthProfile.toDomain(result);
    }
}
