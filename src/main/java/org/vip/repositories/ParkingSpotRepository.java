package org.vip.repositories;

import org.vip.models.parking.ParkingFloor;
import org.vip.models.parking.ParkingLot;
import org.vip.models.parking.ParkingSpot;

import java.util.ArrayList;
import java.util.List;

public class ParkingSpotRepository {
    public List<ParkingSpot> getParkingSpotsByParkingLot(ParkingLot parkingLot) {
        List<ParkingSpot> totalParkingSpots = new ArrayList<>();

        // Approach 1: for each ParkingFloor of the current parkingLot, go to db and get the list of ParkingSpots.
        // Then add it to totalParkingSpots. This approach is slow as there are a lot of db calls.
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for (ParkingFloor parkingFloor: parkingFloors) {
            totalParkingSpots.addAll(parkingFloor.getParkingSpots());
        }
        return totalParkingSpots;

        // Approach 2: for current parkingLot, fetch entire ParkingSpots of all the floors in the parkingLot using joins.
        // Then return the fetched parkingSpots. We can't have this in our demo without db. So skipping this.
        // This is better than Approach 1.
    }
}
