package org.vip.services;

import org.vip.models.parking.Gate;
import org.vip.models.parking.ParkingLot;
import org.vip.repositories.ParkingLotRepository;

public class ParkingLotService {
    private ParkingLotRepository parkingLotRepository;

    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }

    public ParkingLot getParkingLotByGateNumber(Integer gateNumber) {
        return parkingLotRepository.getParkingLotByGateNumber(gateNumber);
    }
}