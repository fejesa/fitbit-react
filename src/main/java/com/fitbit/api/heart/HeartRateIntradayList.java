package com.fitbit.api.heart;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HeartRateIntradayList {

    private final List<HeartRate> dataset;

    private final int datasetInterval;

    private final String datasetType;

    @JsonCreator
    public HeartRateIntradayList(@JsonProperty("dataset") List<HeartRate> dataset,
                                 @JsonProperty("datasetInterval") int datasetInterval, @JsonProperty("datasetType") String datasetType) {
        this.dataset = dataset;
        this.datasetInterval = datasetInterval;
        this.datasetType = datasetType;
    }

    public List<HeartRate> getDataset() {
        return dataset;
    }

    public int getDatasetInterval() {
        return datasetInterval;
    }

    public String getDatasetType() {
        return datasetType;
    }
}
