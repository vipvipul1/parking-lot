package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.exceptions.GateNotFoundException;
import org.vip.parkinglot.models.parking.ParkingSpot;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) throws GateNotFoundException;
}
