package com.mealci.core.poop_monitoring;

import com.mealci.core.additional_asspects.AdditionalAsspect;
import com.mealci.core.feeling.Feeling;
import com.mealci.core.stool_composition.StoolComposition;
import lombok.Getter;

import java.time.Instant;

@Getter
public class PoopMonitoring {
    public Instant createdAt;
    public StoolComposition stoolComposition;
    public int quantity;
    public Feeling feeling;
    public AdditionalAsspect additionalAsspect;
    public int poopingNumber;

    private PoopMonitoring(Instant ceratedAt,
                           StoolComposition stoolComposition,
                           int quantity,
                           Feeling feeling,
                           AdditionalAsspect additionalAsspect,
                           int poopingNumber) {
        this.createdAt = ceratedAt;
        this.stoolComposition = stoolComposition;
        this.quantity = quantity;
        this.feeling = feeling;
        this.additionalAsspect = additionalAsspect;
        this.poopingNumber = poopingNumber;
    }

    public static PoopMonitoring create(Instant createdAt,
                                        StoolComposition stoolComposition,
                                        int quantity,
                                        Feeling feeling,
                                        AdditionalAsspect additionalAsspect,
                                        int poopingNumber)
    {
        return new PoopMonitoring(createdAt,
                stoolComposition,
                quantity,
                feeling,
                additionalAsspect,
                poopingNumber);
    }
}
