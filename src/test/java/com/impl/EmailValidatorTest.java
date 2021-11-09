package com.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailValidatorTest {
    private EmailValidator emailValidator;

    @BeforeEach
    void emailValidator_setUp() {
        emailValidator = new EmailValidator("gmail", "com");
    }

    @Test
    void emailValidator_testContainsAt() {
        assertTrue(emailValidator.validateEmail("mail@gmail.com"));
    }

    @Test
    void emailValidator_testInvalidSymbols() {
        assertFalse(emailValidator.validateEmail("ma%$#@!il@gmail.com"));
    }

    @Test
    void emailValidator_testCorrectDomain() {
        assertFalse(emailValidator.validateEmail("mail@yahoo.com"));
    }

    @Test
    void emailValidator_testCorrectTld() {
        assertFalse(emailValidator.validateEmail("mail@gmail.lt"));
    }
}
