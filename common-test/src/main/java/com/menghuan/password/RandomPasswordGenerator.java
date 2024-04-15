package com.menghuan.password;

import java.security.SecureRandom;

class CustomPasswordGenerator {
    private static final String UPPER_CASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWER_CASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARS = "!@#$%^&*()-_=+[{]}\\|;:'\",<.>/?";

    private static final SecureRandom random = new SecureRandom();

    public static String generateCustomPassword(int length) {
        StringBuilder password = new StringBuilder(length);
        password.append(getRandomChar(UPPER_CASE));
        password.append(getRandomChar(LOWER_CASE));
        password.append(getRandomChar(DIGITS));
        password.append(getRandomChar(SPECIAL_CHARS));

        for (int i = 4; i < length; i++) {
            String charSet = getRandomCharSet();
            password.append(getRandomChar(charSet));
        }

        return password.toString();
    }

    private static String getRandomCharSet() {
        String[] charSets = {UPPER_CASE, LOWER_CASE, DIGITS, SPECIAL_CHARS};
        int randomIndex = random.nextInt(charSets.length);
        return charSets[randomIndex];
    }

    private static char getRandomChar(String charSet) {
        int randomIndex = random.nextInt(charSet.length());
        return charSet.charAt(randomIndex);
    }

    public static void main(String[] args) {
        int passwordLength = 12; // 生成密码的长度
        String generatedPassword = generateCustomPassword(passwordLength);
        System.out.println("Generated Password: " + generatedPassword);
    }
}

