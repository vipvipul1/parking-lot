package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.exceptions.GateNotFoundException;
import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.models.parking.ParkingLot;
import org.vip.parkinglot.models.parking.ParkingSpot;
import org.vip.parkinglot.models.parking.ParkingSpotStatus;
import org.vip.parkinglot.services.ParkingLotService;
import org.vip.parkinglot.services.ParkingSpotService;

import java.util.List;

// Returns the first available parking spot in the entered parking lot.
public class RandomSpotAssignmentStrategy implements ParkingSpotAssignmentStrategy {
    private ParkingLotService parkingLotService;
    private ParkingSpotService parkingSpotService;

    public RandomSpotAssignmentStrategy(ParkingLotService parkingLotService, ParkingSpotService parkingSpotService) {
        this.parkingLotService = parkingLotService;
        this.parkingSpotService = parkingSpotService;
    }

    @Override
    public ParkingSpot assignParkingSpot(UserParkingPreference userParkingPreference) throws GateNotFoundException {
        Gate entryGate = userParkingPreference.getEntryGate();
        ParkingLot parkingLot = parkingLotService.getParkingLotByGateNumber(entryGate.getGateNumber());
        if (parkingLot != null) {
            List<ParkingSpot> parkingSpots = parkingSpotService.getParkingSpotsByParkingLot(parkingLot);
            for (ParkingSpot spot: parkingSpots) {
                if (spot.getVehicleTypes().contains(userParkingPreference.getVehicleType())
                        && spot.getParkingSpotStatus() == ParkingSpotStatus.AVAILABLE) {
                    return spot;
                }
            }
        } else {
            System.out.println("Error in RandomSpotAssignmentStrategy :: assignParkingSpot() :: Invalid gate number passed!");
            throw new GateNotFoundException("Gate Number is Invalid!");
        }
        return null;
    }
}
