package com.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PhoneValidator {
    private List<Predicate<String>> predicateList = new ArrayList<>();

    public List<Predicate<String>> getPredicateList() {
        return this.predicateList;
    }

    public String formatNumber(String phoneNumber) {
        if (phoneNumber.startsWith("8")) {
            return "+370".concat(phoneNumber.substring(1));
        }
        return phoneNumber;
    }

    public boolean validatePhoneNumber(String phoneNumber) {
        ArrayList<Boolean> doesMatchPredicates = new ArrayList();
        boolean isInvalidPhoneString = this.isInvalidPhoneString(phoneNumber);

        if (!this.predicateList.isEmpty()) {
            for (Predicate<String> predicate : this.predicateList) {
                doesMatchPredicates.add(predicate.test(phoneNumber));
            }
        }

        return !isInvalidPhoneString && !doesMatchPredicates.contains(false);
    }


    private boolean isInvalidPhoneString(String phoneNumber) {
        long invalidCharCount = phoneNumber.chars().filter(ch -> !Character.isDigit(ch) && ch != '+').count();
        return invalidCharCount > 0;
    }
}
