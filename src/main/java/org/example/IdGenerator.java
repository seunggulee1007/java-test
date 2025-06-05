package org.example;

import java.security.SecureRandom;

public class IdGenerator {
    // starts at the year 2010
    private static final long DOORAY_EPOCH_MILLIS = 1262304000000L;
    // left shift amounts
    private static final int TIMESTAMP_SHIFT = 23;
    // exclusive
    private static final int MAX_RANDOM = 0x800000;

    public static Long generate() {
        long time = System.currentTimeMillis() - DOORAY_EPOCH_MILLIS;
        return (time << TIMESTAMP_SHIFT) + new SecureRandom().nextInt(MAX_RANDOM);
    }
}

