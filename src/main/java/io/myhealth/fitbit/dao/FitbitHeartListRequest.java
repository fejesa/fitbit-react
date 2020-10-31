package io.myhealth.fitbit.dao;

import java.time.LocalDate;

public class FitbitHeartListRequest {

    private final LocalDate from;

    private final LocalDate to;

    public FitbitHeartListRequest(LocalDate from, LocalDate to) {
        this.from = from;
        this.to = to;
    }

    public LocalDate getFrom() {
        return from;
    }

    public LocalDate getTo() {
        return to;
    }
}
