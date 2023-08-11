package org.vip.parkinglot.dtos;

import org.vip.parkinglot.models.vehicle.VehicleType;
import org.vip.parkinglot.strategies.spotassignment.UserParkingPreference;

public class GenerateTicketRequestDto {
    private String vehicleNumber;
    private VehicleType vehicleType;
    private Integer gateNumber;
    private UserParkingPreference userParkingPreference;

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Integer getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(Integer gateNumber) {
        this.gateNumber = gateNumber;
    }

    public UserParkingPreference getUserParkingPreference() {
        return userParkingPreference;
    }

    public void setUserParkingPreference(UserParkingPreference userParkingPreference) {
        this.userParkingPreference = userParkingPreference;
    }
}
