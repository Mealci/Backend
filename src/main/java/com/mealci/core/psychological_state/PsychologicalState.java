package com.mealci.core.psychological_state;

import lombok.Getter;

@Getter
public enum PsychologicalState {
    VERY_BAD(1),
    BAD(2),
    OK(3),
    GOOD(4),
    VERY_GOOD(5);

    private final int value;

    PsychologicalState(int value) {
        this.value = value;
    }

    public static PsychologicalState fromValue(int value) {
        for (PsychologicalState psychologicalState : PsychologicalState.values()) {
            if (psychologicalState.getValue() == value) {
                return psychologicalState;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
