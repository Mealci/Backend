package com.mealci.core.base.entities;

import com.mealci.core.base.Entity;
import lombok.Getter;

@Getter
public final class TestEntity extends Entity<Integer> {
    public final String test;

    private TestEntity(int id, String test) {
        super(id);
        this.test = test;
    }

    public static TestEntity create(int id, String test)
    {
        return new TestEntity(id, test);
    }
}
