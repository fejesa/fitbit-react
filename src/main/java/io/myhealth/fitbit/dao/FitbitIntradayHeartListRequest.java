package io.myhealth.fitbit.dao;

import java.time.LocalDate;

public class FitbitIntradayHeartListRequest {

    /** The date, in the format yyyy-MM-dd or today.*/
    private final LocalDate date;

    /** Number of data points to include. Either 1sec or 1min */
    private final String detailLevel;

    public FitbitIntradayHeartListRequest(LocalDate date, String detailLevel) {
        this.date = date;
        this.detailLevel = detailLevel;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDetailLevel() {
        return detailLevel;
    }
}
