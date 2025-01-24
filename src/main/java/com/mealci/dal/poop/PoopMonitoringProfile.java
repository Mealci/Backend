package com.mealci.dal.poop;

import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.stool_composition.StoolComposition;
import com.mealci.core.users.User;
import com.mealci.dal.users.UserProfile;

public class PoopMonitoringProfile {
    public static PoopMonitoringEntity toEntity(PoopMonitoring poopMonitoring, User user) {
        if (poopMonitoring == null) {
            return null;
        }

        var entity = new PoopMonitoringEntity();
        entity.setCreatedAt(poopMonitoring.createdAt);
        entity.setStoolComposition(poopMonitoring.stoolComposition.getValue());
        entity.setPoopingNumber(poopMonitoring.poopingNumber);
        entity.setUser(UserProfile.toEntity(user));

        return entity;
    }

    public static PoopMonitoring toDomain(PoopMonitoringEntity entity) {
        if (entity == null) {
            return null;
        }

        return PoopMonitoring.create(
                entity.getCreatedAt(),
                StoolComposition.fromValue(entity.getStoolComposition()),
                entity.getPoopingNumber(),
                entity.getUser().id
        );
    }
}
