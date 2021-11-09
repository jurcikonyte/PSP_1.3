package com.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PhoneValidatorTest {

    private PhoneValidator phoneValidator;

    @BeforeEach
    void phoneValidator_setUp() {
        phoneValidator = new PhoneValidator();
    }

    @Test
    void phoneValidator_testNumberFormatting() {
        assertEquals("+37065869647", phoneValidator.formatNumber("865869647"));
    }

    @Test
    void phoneValidator_testAllNumbers() {
        assertTrue(phoneValidator.validatePhoneNumber("65869647"));
    }

    @Test
    void phoneValidator_testExtraPredicate() {
        phoneValidator.getPredicateList().add(number -> number.length() > 9);
        phoneValidator.getPredicateList().add(number -> number.startsWith("+44"));
        assertFalse(phoneValidator.validatePhoneNumber("65869647"));
    }
}
