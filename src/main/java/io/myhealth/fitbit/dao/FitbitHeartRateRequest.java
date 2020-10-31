package io.myhealth.fitbit.dao;

import java.time.LocalDate;
import java.time.LocalTime;

public class FitbitHeartRateRequest {

    /** The date, in the format yyyy-MM-dd or today.*/
    private final LocalDate date;

    /** Number of data points to include. Either 1sec or 1min */
    private final String detailLevel;

    /** The start of the period, in the format HH:mm. Optional. */
    private final LocalTime startTime;

    /** The end of the period, in the format HH:mm. Optional. */
    private final LocalTime endTime;

    public FitbitHeartRateRequest(LocalDate date, String detailLevel, LocalTime startTime, LocalTime endTime) {
        this.date = date;
        this.detailLevel = detailLevel;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDetailLevel() {
        return detailLevel;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
