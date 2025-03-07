package com.mealci.core.health.patch_health_psychological_state;

import com.mealci.core.physical_dolor.PhysicalDolor;
import com.mealci.core.psychological_state.PsychologicalState;

public record PatchHealthPsychologicalStateResponse(PsychologicalState psychologicalState, PhysicalDolor physicalDolor) {}
