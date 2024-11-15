package com.mealci.tests.core.base.entities;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EntityTests {
    private final TestEntity entityOne = TestEntity.create(1, "test");
    private final TestEntity entityTwo = TestEntity.create(2, "test");

    private Object getNullEntity() {
        return null;
    }

    @Test
    public void equalsHappyPath() {
        // Assert
        var entity = TestEntity.create(1, "test");

        // Act
        var result = entityOne.equals(entity);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void equalsNull() {
        // Act
        var result = entityOne.equals(getNullEntity());

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void equalsDifferentClass() {
        // Arrange
        var object = new Object();

        // Act
        var result = entityOne.equals(object);

        // Assert
        Assert.assertFalse(result);
    }

    @Test
    public void equalsDifferentEntity() {
        // Act
        var result = entityOne.equals(entityTwo);

        // Arrange
        Assert.assertFalse(result);
    }
}
