package org.vip;

import org.vip.controllers.TicketController;
import org.vip.dtos.GenerateTicketRequestDto;
import org.vip.models.billing.Ticket;
import org.vip.models.parking.ParkingFloor;
import org.vip.models.vehicle.VehicleType;
import org.vip.strategies.spotassignment.UserParkingPreference;

public class ParkingLotApp {
    public static void main(String[] args) {
        TicketController ticketController = initializeTicketControllerDependencies();

        GenerateTicketRequestDto ticketRequestDto = new GenerateTicketRequestDto();
        ticketRequestDto.setGateNumber(2);
        ticketRequestDto.setVehicleNumber("KA 23H 4433");
        ticketRequestDto.setVehicleType(VehicleType.SEDAN);

        // If user has any parking preference then take these inputs
        // otherwise keep userParkingPreference as null in ticketRequestDto.
        UserParkingPreference userParkingPreference = new UserParkingPreference();
        ticketRequestDto.setUserParkingPreference(userParkingPreference);

        Ticket ticket = ticketController.generateTicket();
    }

    private static TicketController initializeTicketControllerDependencies() {
        TicketController ticketController = new TicketController();
        return ticketController;
    }
}
