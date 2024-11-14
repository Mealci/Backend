package com.mealci.tests.core.base.value_objects;

import com.mealci.core.base.ValueObject;
import lombok.Getter;

@Getter
public class TestValueObject extends ValueObject {
    public final String test;
    public final int value;

    private TestValueObject(String test, int value) {
        this.test = test;
        this.value = value;
    }

    @Override
    protected String toStringAttributes() {
        return String.format("%s%d", test, value);
    }

    public static TestValueObject create(String test, int value) {
        return new TestValueObject(test, value);
    }
}
