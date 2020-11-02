package io.myhealth.fitbit.transform;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class DateTimeTransformer {

    public static LocalDate fromString(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ISO_DATE);
    }

    public static String fromDate(LocalDate date) {return date.format(DateTimeFormatter.ISO_DATE); }

    public static String formatTime(LocalTime time) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm");
        return time.format(dtf);
    }
}
