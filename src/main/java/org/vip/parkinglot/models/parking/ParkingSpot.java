package org.vip.parkinglot.models.parking;

import org.vip.parkinglot.models.vehicle.VehicleType;

import java.util.List;

public class ParkingSpot {
    private Integer parkingSpotId;
    private String spotNumber;
    private List<VehicleType> vehicleTypes;
    private ParkingFloor parkingFloor;
    private ParkingSpotStatus parkingSpotStatus;
    private ParkingCategory parkingCategory;

    public Integer getParkingSpotId() {
        return parkingSpotId;
    }

    public void setParkingSpotId(Integer parkingSpotId) {
        this.parkingSpotId = parkingSpotId;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public ParkingFloor getParkingFloor() {
        return parkingFloor;
    }

    public void setParkingFloor(ParkingFloor parkingFloor) {
        this.parkingFloor = parkingFloor;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public ParkingCategory getParkingCategory() {
        return parkingCategory;
    }

    public void setParkingCategory(ParkingCategory parkingCategory) {
        this.parkingCategory = parkingCategory;
    }
}
