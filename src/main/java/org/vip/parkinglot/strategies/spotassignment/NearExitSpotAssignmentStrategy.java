package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.models.parking.ParkingSpot;

// System knows the Exit Gate. So based on this Gate, this class will calculate the available ParkingSpot nearest to Exit.
public class NearExitSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    @Override
    public ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) {
        return null;
    }
}
