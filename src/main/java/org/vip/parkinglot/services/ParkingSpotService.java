package org.vip.parkinglot.services;

import org.vip.parkinglot.models.parking.ParkingLot;
import org.vip.parkinglot.models.parking.ParkingSpot;
import org.vip.parkinglot.repositories.ParkingSpotRepository;

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
