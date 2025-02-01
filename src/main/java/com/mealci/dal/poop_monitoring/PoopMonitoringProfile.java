package com.mealci.dal.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.feeling.Feeling;
import com.mealci.core.poop_monitoring.PoopMonitoring;
import com.mealci.core.stool_composition.StoolComposition;

public class PoopMonitoringProfile {
    public static PoopMonitoringEntity toEntity(PoopMonitoring poopMonitoring) {
        if (poopMonitoring == null) {
            return null;
        }

        var entity = new PoopMonitoringEntity();
        entity.setCreatedAt(poopMonitoring.createdAt);
        entity.setStoolComposition(poopMonitoring.stoolComposition.getValue());
        entity.setQuantity(poopMonitoring.getQuantity());
        entity.setFeeling(poopMonitoring.getFeeling().getValue());
        entity.setHasExcessiveFlatulence(poopMonitoring.additionalAsspect.hasExcessiveFlatulence);
        entity.setHasPain(poopMonitoring.additionalAsspect.hasPain);
        entity.setHasAbdominalBloating(poopMonitoring.additionalAsspect.hasAbdominalBloating);
        entity.setHasMucus(poopMonitoring.additionalAsspect.hasMucus);
        entity.setHasFoodResidue(poopMonitoring.additionalAsspect.hasFoodResidue);
        entity.setHasColic(poopMonitoring.additionalAsspect.hasColic);
        entity.setHasUnusualSmells(poopMonitoring.additionalAsspect.hasUnusualSmells);
        entity.setPoopingNumber(poopMonitoring.poopingNumber);

        return entity;
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
                additionalAsspect,
                entity.poopingNumber);
    }
}
