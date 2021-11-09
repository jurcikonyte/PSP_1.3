package com.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordCheckerTest {

    private PasswordChecker passwordChecker;

    @BeforeEach
    void passwordChecker_setUp() {
        passwordChecker = new PasswordChecker(8, "!@#$%^&*()-=+");
    }

    @Test
    void passwordChecker_testValidPassword() {
        assertTrue(passwordChecker.validatePassword("PASSWORD123!@#"));
    }

    @Test
    void passwordChecker_testInvalidUpperCase() {
        assertFalse(passwordChecker.validatePassword("password123!@#"));
    }

    @Test
    void passwordChecker_testInvalidSymbols() {
        assertFalse(passwordChecker.validatePassword("PASSWORD123"));
    }

    @Test
    void passwordChecker_testInvalidLength() {
        assertFalse(passwordChecker.validatePassword("Pass!@"));
    }
}
