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
        entity.setHasExcessiveFlatulence(poopMonitoring.additionalAsspect.HasExcessiveFlatulence);
        entity.setHasPain(poopMonitoring.additionalAsspect.HasPain);
        entity.setHasAbdominalBloating(poopMonitoring.additionalAsspect.HasAbdominalBloating);
        entity.setHasMucus(poopMonitoring.additionalAsspect.HasMucus);
        entity.setHasFoodResidue(poopMonitoring.additionalAsspect.HasFoodResidue);
        entity.setHasColic(poopMonitoring.additionalAsspect.HasColic);
        entity.setHasUnusualSmells(poopMonitoring.additionalAsspect.HasUnusualSmells);
        entity.setPoopingNumber(poopMonitoring.poopingNumber);

        return entity;
    }

    public static PoopMonitoring toDomain(PoopMonitoringEntity entity) {
        if (entity == null) {
            return null;
        }

        var additionalAsspect = AdditionalAsspect.create(entity.HasExcessiveFlatulence,
                entity.HasPain,
                entity.HasAbdominalBloating,
                entity.HasMucus,
                entity.HasFoodResidue,
                entity.HasColic,
                entity.HasUnusualSmells);

        return PoopMonitoring.create(
                entity.createdAt,
                StoolComposition.fromValue(entity.stoolComposition),
                entity.quantity,
                Feeling.fromValue(entity.feeling),
                additionalAsspect,
                entity.poopingNumber);
    }
}
