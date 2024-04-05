package com.ecommerce.ecommerce.feature.auth.service;

import java.security.SecureRandom;

public class GeneratePassword {
    private static final String LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL = "!@#$%^&*()-_=+";

    private static final String ALL = LOWER + UPPER + DIGITS + SPECIAL;
    private static final SecureRandom random = new SecureRandom();

    public static String generate(int length) {
        StringBuilder password = new StringBuilder(length);
        password.append(getRandomChar(LOWER));
        password.append(getRandomChar(UPPER));
        password.append(getRandomChar(DIGITS));
        password.append(getRandomChar(SPECIAL));

        for (int i = 4; i < length; i++) {
            password.append(getRandomChar(ALL));
        }

        return password.toString();
    }

    private static char getRandomChar(String characters) {
        int randomIndex = random.nextInt(characters.length());
        return characters.charAt(randomIndex);
    }

    public static void main(String[] args) {
        int length = 8;
        String password = GeneratePassword.generate(length);
    }
}
