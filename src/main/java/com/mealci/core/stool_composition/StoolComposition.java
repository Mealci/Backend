package com.mealci.core.stool_composition;

import lombok.Getter;

@Getter
public enum StoolComposition {
    TYPE_ONE(1),
    TYPE_TWO(2),
    TYPE_THREE(3),
    TYPE_FOUR(4),
    TYPE_FIVE(5),
    TYPE_SIX(6),
    TYPE_SEVEN(7),
    TYPE_NONE(8),
    TYPE_UNKNOW(9);

    private final int value;

    StoolComposition(int value) {
        this.value = value;
    }

    public static StoolComposition fromValue(int value) {
        for (StoolComposition stoolComposition : StoolComposition.values()) {
            if (stoolComposition.getValue() == value) {
                return stoolComposition;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
