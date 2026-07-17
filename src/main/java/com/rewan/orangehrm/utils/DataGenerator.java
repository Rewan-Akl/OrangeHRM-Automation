package com.rewan.orangehrm.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DataGenerator {

    public static String generateUsername() {
        return "user" + LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
    }

    public static String generatePassword() {
        return "Orange@123";
    }
}