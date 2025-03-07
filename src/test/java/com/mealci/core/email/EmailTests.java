package com.mealci.core.email;

import org.junit.Assert;
import org.junit.Test;
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

//    @ParameterizedTest
//    @ValueSource(strings = {
//            "test@gmail.com",
//            "34@exemple.com",
//            "test@mail.eu",
//            "test@mail",
//            "@mail.com",
//            "mail.com",
//            "test@.com",
//            ".com",
//            "test"
//    })
//    public void createWrongFormat(String email) {
//        // Act and Assert
//        Assert.assertThrows(CoreException.class, () -> Email.create(email));
//    }
}
