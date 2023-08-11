package org.vip.parkinglot.services;

import org.vip.parkinglot.models.parking.ParkingLot;
import org.vip.parkinglot.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotByGateNumber(Integer gateNumber) {
        return parkingLotRepository.getParkingLotByGateNumber(gateNumber);
    }
}