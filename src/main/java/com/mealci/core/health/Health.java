package com.mealci.core.health;

import com.mealci.core.base.ValueObject;
import com.mealci.core.physical_dolor.PhysicalDolor;
import com.mealci.core.psychological_state.PsychologicalState;

public class Health extends ValueObject {
    public final PsychologicalState psychologicalState;
    public final PhysicalDolor physicalDolor;

    private Health(PsychologicalState psychologicalState,
                   PhysicalDolor physicalDolor) {
        this.psychologicalState = psychologicalState;
        this.physicalDolor = physicalDolor;
    }

    public static Health create(PsychologicalState psychologicalState,
                                PhysicalDolor physicalDolor) {
        return new Health(psychologicalState, physicalDolor);
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%s", psychologicalState, physicalDolor);
    }
}
