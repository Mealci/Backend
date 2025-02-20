package com.mealci.dal.health;

import com.mealci.core.health.Health;
import com.mealci.core.physical_dolor.PhysicalDolor;
import com.mealci.core.psychological_state.PsychologicalState;

public class HealthProfile {

    public static HealthEntity toEntity(Health health) {
        var entity = new HealthEntity();
        entity.setPsychologicalState(health.psychologicalState.getValue());
        entity.setPhysicalDolor(health.physicalDolor.getValue());

        return entity;
    }

    public static Health toDomain(HealthEntity entity) {
        return Health.create(
                PsychologicalState.fromValue(entity.getPsychologicalState()),
                PhysicalDolor.fromValue(entity.getPhysicalDolor()));
    }
}
