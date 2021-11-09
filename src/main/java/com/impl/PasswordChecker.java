package com.impl;

public class PasswordChecker {
    private int passwordLength;
    private String specialCharacters;

    public PasswordChecker(int passwordLength, String specialCharacters) {
        this.passwordLength = passwordLength;
        this.specialCharacters = specialCharacters;
    }

    public boolean validatePassword(String password) {
        boolean isCorrectLength = password.length() >= this.passwordLength;
        boolean hasUppercase = this.containsUppercase(password);
        boolean hasSpecialCharacters = this.checkForSpecialChars(password);

        return isCorrectLength && hasUppercase && hasSpecialCharacters;
    }

    private boolean containsUppercase(String password) {
        long uppercaseCount = password.chars().filter(ch -> Character.isUpperCase(ch)).count();
        return uppercaseCount > 0;
    }

    private boolean checkForSpecialChars(String password) {
        long symbolCount = password.chars().filter(ch -> this.specialCharacters.indexOf(ch) >= 0).count();
        return symbolCount > 0;
    }
}
