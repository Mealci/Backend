package com.mealci.core.poop_monitoring.create;

import com.mealci.core.feeling.Feeling;
import com.mealci.core.stool_composition.StoolComposition;

public record CreatePoopMonitoringRequest(StoolComposition stoolComposition,
                                          int quantity,
                                          Feeling feeling,
                                          boolean HasExcessiveFlatulence,
                                          boolean HasPain,
                                          boolean HasAbdominalBloating,
                                          boolean HasMucus,
                                          boolean HasFoodResidue,
                                          boolean HasColic,
                                          boolean HasUnusualSmells) { }
