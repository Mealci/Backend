package com.mealci.core.poop_monitoring;

import com.mealci.core.stool_composition.StoolComposition;
import lombok.Getter;

import java.util.Date;

@Getter
public class PoopMonitoring {
    public Date createdAt;
    public StoolComposition stoolComposition;
    public int poopingNumber;
    public int userId;

    private PoopMonitoring(Date createdAt,
                           StoolComposition stoolComposition,
                           int poopingNumber,
                           int userId) {
        this.createdAt = createdAt;
        this.stoolComposition = stoolComposition;
        this.poopingNumber = poopingNumber;
        this.userId = userId;
    }

    public static PoopMonitoring create(Date createdAt,
                                        StoolComposition stoolComposition,
                                        int poopingNumber,
                                        int userId)
    {
        return new PoopMonitoring(createdAt, stoolComposition, poopingNumber, userId);
    }
}
