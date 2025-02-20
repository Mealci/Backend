package com.mealci.dal.health.repositories;

import com.mealci.core.health.Health;
import com.mealci.core.psychological_state.PsychologicalState;

public interface CustomHealthRepository {
    Health patch(PsychologicalState psychologicalState, int id);
}
