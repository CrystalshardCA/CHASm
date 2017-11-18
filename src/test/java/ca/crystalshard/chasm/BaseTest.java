package ca.crystalshard.chasm;

import java.util.Random;

public class BaseTest {
    private Random random = new Random();
    private String alphaNumericString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    protected String anonString() {
        return anonString(20);
    }

    protected int anonInt() {
        return random.nextInt();
    }

    private String anonString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append(alphaNumericString.charAt(random.nextInt(alphaNumericString.length())));
        }
        return sb.toString();
    }
}
