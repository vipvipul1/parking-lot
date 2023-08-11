package org.vip.parkinglot.repositories;

import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.models.parking.ParkingLot;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap = new HashMap<>();
    public ParkingLot getParkingLotByGateNumber(Integer gateNumber) {
        for(ParkingLot parkingLot: parkingLotMap.values()) {
            for (Gate gate: parkingLot.getGates()) {
                if (Objects.equals(gate.getGateNumber(), gateNumber)) {
                    return parkingLot;
                }
            }
        }
        return null;
    }
}
