package org.vip.models.parking;

import java.util.List;

public class ParkingFloor {
    private Integer parkingFloorId;
    private List<ParkingSpot> parkingSpots;
    private Integer floorNo;

    public Integer getParkingFloorId() {
        return parkingFloorId;
    }

    public void setParkingFloorId(Integer parkingFloorId) {
        this.parkingFloorId = parkingFloorId;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }
}
