package org.vip.parkinglot.models.parking;

import java.time.LocalDateTime;

public class EVCharger {
    private Integer evChargerId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer ratePerHour;

    public Integer getEvChargerId() {
        return evChargerId;
    }

    public void setEvChargerId(Integer evChargerId) {
        this.evChargerId = evChargerId;
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
