package com.mealci.tests.core.email;

import com.mealci.core.email.Email;
import com.mealci.core.exceptions.CoreException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailTests {
    @Test
    public void createHappyPath() {
        // Arrange
        var expected = Email.create("test@mail.com");

        // Act
        var result = Email.create("test@mail.com");

        // Assert
        Assert.assertTrue(result.valueEquals(expected));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "test@mail",
            "@mail.com",
            "mail.com",
            "test@.com",
            ".com",
            "test"
    })
    public void createWrongFormat(String email) {
        // Act and Assert
        Assert.assertThrows(CoreException.class, () -> Email.create(email));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "test@gmail.com",
            "34@exemple.com",
            "test@mail.eu"
    })
    public void createWrongEmail(String email) {
        // Arrange
        var result = Email.create(email);

        // Assert
        Assert.assertEquals(result.address, email);
    }
}
