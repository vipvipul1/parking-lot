package org.vip.parkinglot.models.parking;

import org.vip.parkinglot.models.vehicle.VehicleType;

import java.util.List;

// There will be some ParkingSpots which will have EVCharger. But we aren't storing EVCharger inside ParkingSpot
// because % of ParkingSpots with EVCharger out of total ParkingSpots will be very less and due to this there will
// be a lot of null values of evChargerId in ParkingSpot table. These huge null values are called sparse data.
// To get rid of this sparse data for evChargerId in ParkingSpot table, we can use a new mapping table
// ParkingSpotEVChargerMapping with parkingSpotId, evChargerId.
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
