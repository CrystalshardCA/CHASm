package ca.crystalshard.chasm;

import ca.crystalshard.chasm.crawler.domain.identifier.PinId;

import java.net.URL;
import java.util.Random;

@SuppressWarnings("SameParameterValue")
public class BaseTest {
    private Random random = new Random();
    private String alphaNumericString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    protected URL anonUrl() {
        try {
            return new URL("http", anonString(), 80, "/");
        } catch (Exception ignored) {

        }
        return null;
    }

    protected PinId anonPinId() {
        return PinId.of(String.valueOf(anonInt(99)));
    }

    protected String anonString() {
        return anonString(20);
    }

    protected int anonInt() {
        return random.nextInt();
    }

    private int anonInt(int bound) {
        return random.nextInt(bound);
    }

    private String anonString(int length) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
            sb.append(alphaNumericString.charAt(random.nextInt(alphaNumericString.length())));
        }
        return sb.toString();
    }
}
