package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.models.parking.ParkingSpot;

// System knows the Gate Near Mall. So based on this Gate, this class will calculate the available ParkingSpot nearest to this Gate.
public class NearMallSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    @Override
    public ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) {
        return null;
    }
}
