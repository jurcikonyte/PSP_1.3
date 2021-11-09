package com.impl;

public class EmailValidator {
    private String TLD;
    private String domain;

    public EmailValidator(String domain, String TLD) {
        this.domain = domain;
        this.TLD = TLD;
    }

    public boolean validateEmail(String email) {
        Integer etaIndex = this.checkForSymbol(email, '@');
        Integer dotIndex = this.checkForSymbol(email, '.');
        boolean hasInvalidSymbols = this.checkForInvalidSymbols(email, "!#$%^&*()-=+");
        if (hasInvalidSymbols || etaIndex == null || dotIndex == null || etaIndex > dotIndex) {
            return false;
        }

        String emailDomain = email.trim().substring(etaIndex + 1, dotIndex);
        String emailTLD = email.trim().substring(dotIndex + 1);
        if (!emailDomain.equals(this.domain) || !emailTLD.equals(this.TLD)) {
            return false;
        }
        ;

        return true;
    }

    private Integer checkForSymbol(String email, char symbol) {
        long symbolCount = email.chars().filter(ch -> ch == symbol).count();
        if (symbolCount != 1) {
            return null;
        }
        return email.indexOf(symbol);
    }

    private boolean checkForInvalidSymbols(String email, String symbols) {
        long symbolCount = email.chars().filter(ch -> symbols.indexOf(ch) >= 0).count();
        return symbolCount > 0;
    }
}
