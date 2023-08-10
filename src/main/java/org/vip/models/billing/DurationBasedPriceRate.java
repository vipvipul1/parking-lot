package org.vip.models.billing;

import java.time.LocalDateTime;

public class DurationBasedPriceRate {
    private Integer priceRateId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Integer ratePercent;

    public Integer getPriceRateId() {
        return priceRateId;
    }

    public void setPriceRateId(Integer priceRateId) {
        this.priceRateId = priceRateId;
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

    public Integer getRatePercent() {
        return ratePercent;
    }

    public void setRatePercent(Integer ratePercent) {
        this.ratePercent = ratePercent;
    }
}
