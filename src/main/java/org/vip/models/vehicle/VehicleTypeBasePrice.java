package org.vip.models.vehicle;

import org.vip.models.vehicle.VehicleType;

public class VehicleTypeBasePrice {
    private Integer basePriceId;
    private VehicleType vehicleType;
    private Double basePrice;

    public Integer getBasePriceId() {
        return basePriceId;
    }

    public void setBasePriceId(Integer basePriceId) {
        this.basePriceId = basePriceId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }
}
