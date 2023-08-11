package org.vip;

import org.vip.controllers.TicketController;
import org.vip.dtos.GenerateTicketRequestDto;
import org.vip.dtos.TicketResponseDto;
import org.vip.models.vehicle.VehicleType;
import org.vip.repositories.*;
import org.vip.services.*;
import org.vip.strategies.spotassignment.ParkingSpotAssignmentStrategy;
import org.vip.strategies.spotassignment.RandomSpotAssignmentStrategy;
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

        TicketResponseDto ticket = ticketController.generateTicket(ticketRequestDto);
        System.out.println(ticket);
    }

    private static TicketController initializeTicketControllerDependencies() {
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingLotService parkingLotService = new ParkingLotService(parkingLotRepository);

        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingSpotService parkingSpotService = new ParkingSpotService(parkingSpotRepository);

        VehicleRepository vehicleRepository = new VehicleRepository();
        VehicleService vehicleService = new VehicleService(vehicleRepository);

        GateRepository gateRepository = new GateRepository();
        GateService gateService = new GateService(gateRepository);

        // Take input from user for parking preference and then create object of ParkingSpotAssignmentStrategy.
        ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy = new RandomSpotAssignmentStrategy(parkingLotService, parkingSpotService);

        TicketRepository ticketRepository = new TicketRepository();
        TicketService ticketService = new TicketService(vehicleService, gateService, ticketRepository, parkingSpotAssignmentStrategy);
        return new TicketController(ticketService);
    }
}
