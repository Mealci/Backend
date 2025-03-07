package com.mealci.core.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.base.ValueObject;
import com.mealci.core.feeling.Feeling;
import com.mealci.core.stool_composition.StoolComposition;
import lombok.Getter;

import java.time.Instant;

@Getter
public class PoopMonitoring extends ValueObject {
    public final Instant createdAt;
    public final StoolComposition stoolComposition;
    public final int quantity;
    public final Feeling feeling;
    public final AdditionalAsspect additionalAsspect;

    private PoopMonitoring(Instant ceratedAt,
                           StoolComposition stoolComposition,
                           int quantity,
                           Feeling feeling,
                           AdditionalAsspect additionalAsspect) {
        this.createdAt = ceratedAt;
        this.stoolComposition = stoolComposition;
        this.quantity = quantity;
        this.feeling = feeling;
        this.additionalAsspect = additionalAsspect;
    }

    public static PoopMonitoring create(Instant createdAt,
                                        StoolComposition stoolComposition,
                                        int quantity,
                                        Feeling feeling,
                                        AdditionalAsspect additionalAsspect)
    {
        return new PoopMonitoring(createdAt,
                stoolComposition,
                quantity,
                feeling,
                additionalAsspect);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%s%s%s%s",
                createdAt,
                stoolComposition,
                quantity,
                feeling,
                additionalAsspect);
    }
}
