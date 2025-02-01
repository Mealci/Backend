package com.mealci.core.additional_asspects;

import lombok.Getter;

@Getter
public class AdditionalAsspect {

    public boolean HasExcessiveFlatulence;
    public boolean HasPain;
    public boolean HasAbdominalBloating;
    public boolean HasMucus;
    public boolean HasFoodResidue;
    public boolean HasColic;
    public boolean HasUnusualSmells;

    private AdditionalAsspect(boolean hasExcessiveFlatulence,
                              boolean hasPain,
                              boolean hasAbdominalBloating,
                              boolean hasMucus,
                              boolean hasFoodResidue,
                              boolean hasColic,
                              boolean hasUnusualSmells) {
        this.HasExcessiveFlatulence = hasExcessiveFlatulence;
        this.HasPain = hasPain;
        this.HasAbdominalBloating = hasAbdominalBloating;
        this.HasMucus = hasMucus;
        this.HasFoodResidue = hasFoodResidue;
        this.HasColic = hasColic;
        this.HasUnusualSmells = hasUnusualSmells;
    }

    public static AdditionalAsspect create(boolean hasExcessiveFlatulence,
                                           boolean hasPain,
                                           boolean hasAbdominalBloating,
                                           boolean hasMucus,
                                           boolean hasFoodResidue,
                                           boolean hasColic,
                                           boolean hasUnusualSmells) {
        return new AdditionalAsspect(hasExcessiveFlatulence,
                hasPain,
                hasAbdominalBloating,
                hasMucus,
                hasFoodResidue,
                hasColic,
                hasUnusualSmells);
    }
}
