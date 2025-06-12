package com.test.parser.util.string;

import com.study.util.StringUtils;

import java.util.Random;

public class HexGenerator {

    private final Random random = new Random();

    public String generateRandomHex() {
        int raw = random.nextInt(0, 0xF);
        if (raw < 10) {
            return "" + raw;
        }

        int delta = raw - 10;
        if (random.nextBoolean()) {
            return StringUtils.fromCodePoint('A' + delta);
        }
        return StringUtils.fromCodePoint('a' + delta);
    }
}
