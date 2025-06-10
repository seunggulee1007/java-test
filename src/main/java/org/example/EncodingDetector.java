package org.example;

import java.util.regex.Pattern;

public class EncodingDetector {
    private static final Pattern ENCODED_PATTERN = Pattern.compile("%[0-9a-fA-F]{2}");

    public static boolean isUrlEncoded(String input) {
        return ENCODED_PATTERN.matcher(input).find();
    }

    public static void main(String[] args) {
        String encoded = "hello%20world.txt";
        String normal = "한글파일.txt";

        System.out.println(isUrlEncoded(encoded)); // true
        System.out.println(isUrlEncoded(normal));  // false
    }
}