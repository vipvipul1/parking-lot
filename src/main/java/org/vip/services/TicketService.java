package org.vip.services;

import org.vip.dtos.GenerateTicketRequestDto;
import org.vip.dtos.TicketResponseDto;
import org.vip.exceptions.GateNotFoundException;
import org.vip.exceptions.ParkingSpotNotFoundException;
import org.vip.exceptions.UnauthorizedEntryGateException;
import org.vip.models.billing.Ticket;
import org.vip.models.billing.TicketStatus;
import org.vip.models.parking.Gate;
import org.vip.models.parking.GateStatus;
import org.vip.models.parking.ParkingSpot;
import org.vip.models.vehicle.Vehicle;
import org.vip.repositories.TicketRepository;
import org.vip.strategies.spotassignment.ParkingSpotAssignmentStrategy;
import org.vip.strategies.spotassignment.UserParkingPreference;

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
            if (ticketRequestDto.getUserParkingPreference() == null)
                ticketRequestDto.setUserParkingPreference(new UserParkingPreference());
            ticketRequestDto.getUserParkingPreference().setEntryGate(entryGate);
            ticketRequestDto.getUserParkingPreference().setVehicleType(ticketRequestDto.getVehicleType());

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
