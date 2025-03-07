package com.mealci.core.additional_asspects;

import lombok.Getter;

@Getter
public class AdditionalAsspect {

    public final boolean hasExcessiveFlatulence;
    public final boolean hasPain;
    public final boolean hasAbdominalBloating;
    public final boolean hasMucus;
    public final boolean hasFoodResidue;
    public final boolean hasColic;
    public final boolean hasUnusualSmells;

    private AdditionalAsspect(boolean hasExcessiveFlatulence,
                              boolean hasPain,
                              boolean hasAbdominalBloating,
                              boolean hasMucus,
                              boolean hasFoodResidue,
                              boolean hasColic,
                              boolean hasUnusualSmells) {
        this.hasExcessiveFlatulence = hasExcessiveFlatulence;
        this.hasPain = hasPain;
        this.hasAbdominalBloating = hasAbdominalBloating;
        this.hasMucus = hasMucus;
        this.hasFoodResidue = hasFoodResidue;
        this.hasColic = hasColic;
        this.hasUnusualSmells = hasUnusualSmells;
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
