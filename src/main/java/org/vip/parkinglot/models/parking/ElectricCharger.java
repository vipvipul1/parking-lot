package org.vip.parkinglot.models.parking;

import java.time.LocalDateTime;

public class ElectricCharger {
    private Integer electricChargerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer ratePerHour;

    public Integer getElectricChargerId() {
        return electricChargerId;
    }

    public void setElectricChargerId(Integer electricChargerId) {
        this.electricChargerId = electricChargerId;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Integer getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Integer ratePerHour) {
        this.ratePerHour = ratePerHour;
    }
}
