package org.vip.services;

import org.vip.models.parking.ParkingFloor;
import org.vip.models.parking.ParkingLot;
import org.vip.models.parking.ParkingSpot;
import org.vip.models.vehicle.VehicleType;
import org.vip.repositories.ParkingSpotRepository;

import java.util.List;

public class ParkingSpotService {
    private ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public List<ParkingSpot> getParkingSpotsByParkingLot(ParkingLot parkingLot) {
        return parkingSpotRepository.getParkingSpotsByParkingLot(parkingLot);
    }
}
