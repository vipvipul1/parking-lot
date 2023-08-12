package org.vip.parkinglot.services;

import org.vip.parkinglot.dtos.GenerateTicketRequestDto;
import org.vip.parkinglot.dtos.TicketResponseDto;
import org.vip.parkinglot.exceptions.GateNotFoundException;
import org.vip.parkinglot.exceptions.ParkingSpotNotFoundException;
import org.vip.parkinglot.exceptions.UnauthorizedEntryGateException;
import org.vip.parkinglot.models.parking.Ticket;
import org.vip.parkinglot.models.parking.TicketStatus;
import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.models.parking.GateStatus;
import org.vip.parkinglot.models.parking.ParkingSpot;
import org.vip.parkinglot.models.vehicle.Vehicle;
import org.vip.parkinglot.repositories.TicketRepository;
import org.vip.parkinglot.strategies.spotassignment.ParkingSpotAssignmentStrategy;
import org.vip.parkinglot.strategies.spotassignment.UserParkingPreference;

import java.time.LocalDateTime;
import java.util.UUID;

public class TicketService {
    private VehicleService vehicleService;
    private GateService gateService;
    private TicketRepository ticketRepository;
    private ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy;

    public TicketService(VehicleService vehicleService, GateService gateService, TicketRepository ticketRepository,
                         ParkingSpotAssignmentStrategy parkingSpotAssignmentStrategy) {
        this.vehicleService = vehicleService;
        this.gateService = gateService;
        this.ticketRepository = ticketRepository;
        this.parkingSpotAssignmentStrategy = parkingSpotAssignmentStrategy;
    }

    public TicketResponseDto generateTicket(GenerateTicketRequestDto ticketRequestDto)
            throws ParkingSpotNotFoundException, UnauthorizedEntryGateException, GateNotFoundException {
        Ticket ticket = null;
        Gate entryGate = gateService.getGateByGateNumber(ticketRequestDto.getGateNumber());
        if (entryGate != null && entryGate.getGateStatus() == GateStatus.OPEN) {
            UserParkingPreference userParkingPreference = ticketRequestDto.getUserParkingPreference();
            if (userParkingPreference == null)
                userParkingPreference = new UserParkingPreference();
            userParkingPreference.setEntryGate(entryGate);
            userParkingPreference.setVehicleType(ticketRequestDto.getVehicleType());

            ParkingSpot parkingSpot = parkingSpotAssignmentStrategy.assignParkingSpot(ticketRequestDto.getUserParkingPreference());
            if (parkingSpot != null) {
                ticket = new Ticket();
                ticket.setTicketNumber(UUID.randomUUID().hashCode());
                ticket.setParkingSpot(parkingSpot);
                Vehicle vehicle = vehicleService.getVehicleByVehicleNumber(ticketRequestDto.getVehicleNumber());
                if (vehicle == null) {
                    vehicle = vehicleService.registerVehicle(ticketRequestDto.getVehicleNumber(), ticketRequestDto.getVehicleType());
                }
                ticket.setVehicle(vehicle);
                ticket.setEntryGate(entryGate);
                ticket.setEntryDateTime(LocalDateTime.now());
                ticket.setTicketStatus(TicketStatus.CONFIRMED);
                saveTicket(ticket);

                // save userParkingPreference to db so that if any dynamic fee is to be applied
                // based on parkingPreference then we can fetch from db.
                if (ticketRequestDto.getUserParkingPreference() != null) {
                    userParkingPreference.setTicket(ticket);
                    saveUserParkingPreference(userParkingPreference);
                }
            } else {
                System.out.println("Error in TicketService :: generateTicket() :: Parking Spot Not Found!");
                throw new ParkingSpotNotFoundException("No Parking Spot found for the Vehicle Type!");
            }
        } else if (entryGate != null) {
            System.out.println("Error in TicketService :: generateTicket() :: Unauthorized Entry Gate!");
            throw new UnauthorizedEntryGateException("Entry Gate is Unauthorized!");
        } else {
            System.out.println("Error in TicketService :: generateTicket() :: Invalid gate number passed!");
            throw new GateNotFoundException("Gate Number is Invalid!");
        }
        return getTicketResponseDtoFromTicket(ticket);
    }

    public void saveTicket(Ticket ticket) {
        ticketRepository.saveTicket(ticket);
    }

    public void saveUserParkingPreference(UserParkingPreference userParkingPreference) {
        ticketRepository.saveUserParkingPreference(userParkingPreference);
    }

    private TicketResponseDto getTicketResponseDtoFromTicket(Ticket ticket) {
        TicketResponseDto ticketResponseDto = new TicketResponseDto();
        ticketResponseDto.setTicketNumber(ticket.getTicketNumber());
        ticketResponseDto.setSpotNumber(ticket.getParkingSpot().getSpotNumber());
        ticketResponseDto.setVehicle(ticket.getVehicle());
        ticketResponseDto.setEntryGate(ticket.getEntryGate());
        ticketResponseDto.setEntryDateTime(ticket.getEntryDateTime());
        ticketResponseDto.setTicketStatus(ticket.getTicketStatus().getLabel());
        return ticketResponseDto;
    }
}
