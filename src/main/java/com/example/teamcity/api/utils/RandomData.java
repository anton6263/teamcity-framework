package com.example.teamcity.api.utils;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomData {

    private static final String TEST_PREFIX = "test_";
    private static final int MAX_LENGTH = 10;

    public static String getString() {
        return TEST_PREFIX + RandomStringUtils.randomAlphabetic(MAX_LENGTH);
    }


}
