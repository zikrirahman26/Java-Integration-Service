package org.example.integrationapp.utils;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class FormatDateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd HH:mm:ss");

    public static String formatDateTime(LocalDateTime dateTime) {
        return dateTime.format(formatter);
    }
}
