package org.core.models;

import java.io.Serial;
import java.io.Serializable;

public class DetailsModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private int totalFaults;
    private double finalAverage;

    public DetailsModel() {}

    public DetailsModel(int totalFaults, double finalAverage) {
        this.totalFaults = totalFaults;
        this.finalAverage = finalAverage;
    }

    public int getTotalFaults() {
        return totalFaults;
    }

    public void setTotalFaults(int totalFaults) {
        this.totalFaults = totalFaults;
    }

    public double getFinalAverage() {
        return finalAverage;
    }

    public void setFinalAverage(double finalAverage) {
        this.finalAverage = finalAverage;
    }
}
