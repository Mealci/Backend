package com.mealci.dal.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.feeling.Feeling;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.stool_composition.StoolComposition;

public class PoopMonitoringProfile {
    private PoopMonitoringProfile() {}

    public static PoopMonitoringEntity toEntity(PoopMonitoring poopMonitoring) {
        if (poopMonitoring == null) {
            return null;
        }

        return new PoopMonitoringEntity(
                poopMonitoring.createdAt,
                poopMonitoring.stoolComposition.getValue(),
                poopMonitoring.getQuantity(),
                poopMonitoring.getFeeling().getValue(),
                poopMonitoring.additionalAsspect.hasExcessiveFlatulence,
                poopMonitoring.additionalAsspect.hasPain,
                poopMonitoring.additionalAsspect.hasAbdominalBloating,
                poopMonitoring.additionalAsspect.hasMucus,
                poopMonitoring.additionalAsspect.hasFoodResidue,
                poopMonitoring.additionalAsspect.hasColic,
                poopMonitoring.additionalAsspect.hasUnusualSmells);
    }

    public static PoopMonitoring toDomain(PoopMonitoringEntity entity) {
        if (entity == null) {
            return null;
        }

        var additionalAsspect = AdditionalAsspect.create(entity.hasExcessiveFlatulence,
                entity.hasPain,
                entity.hasAbdominalBloating,
                entity.hasMucus,
                entity.hasFoodResidue,
                entity.hasColic,
                entity.hasUnusualSmells);

        return PoopMonitoring.create(
                entity.createdAt,
                StoolComposition.fromValue(entity.stoolComposition),
                entity.quantity,
                Feeling.fromValue(entity.feeling),
                additionalAsspect);
    }
}
