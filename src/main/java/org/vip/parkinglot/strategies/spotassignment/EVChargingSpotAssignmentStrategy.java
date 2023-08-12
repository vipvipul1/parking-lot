package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.exceptions.GateNotFoundException;
import org.vip.parkinglot.models.parking.ParkingSpot;

// Returns a ParkingSpot that supports Electric Charger.
public class EVChargingSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    @Override
    public ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) throws GateNotFoundException {
        return null;
    }
}
