package org.vip.strategies.spotassignment;

import org.vip.exceptions.GateNotFoundException;
import org.vip.models.parking.ParkingSpot;

public interface ParkingSpotAssignmentStrategy {

    ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) throws GateNotFoundException;
}
