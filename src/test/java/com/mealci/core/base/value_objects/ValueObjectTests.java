package com.mealci.core.base.value_objects;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValueObjectTests {
    private final TestValueObject valueObjectOne = TestValueObject.create("test", 1);
    private final TestValueObject valueObjectTwo = TestValueObject.create("test", 2);

    @Test
    public void valueEqualsHappyPath() {
        // Arrange
        var valueObject = TestValueObject.create("test", 1);

        // Act
        var result = valueObjectOne.valueEquals(valueObject);

        // Assert
        Assert.assertTrue(result);
    }

    @Test
    public void valueEqualsDifferentValueObject() {
        // Act
        var result = valueObjectOne.valueEquals(valueObjectTwo);

        // Assert
        Assert.assertFalse(result);
    }
}
