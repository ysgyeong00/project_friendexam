package com.friendexam.board.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class DateUtils {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    public String format(LocalDateTime dateTime) {
        return dateTime != null ? dateTime.format(formatter) : "";
    }
}