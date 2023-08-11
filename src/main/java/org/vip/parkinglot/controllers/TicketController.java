package org.vip.parkinglot.controllers;

import org.vip.parkinglot.dtos.GenerateTicketRequestDto;
import org.vip.parkinglot.dtos.TicketResponseDto;
import org.vip.parkinglot.exceptions.GateNotFoundException;
import org.vip.parkinglot.exceptions.ParkingSpotNotFoundException;
import org.vip.parkinglot.exceptions.UnauthorizedEntryGateException;
import org.vip.parkinglot.models.parking.TicketStatus;
import org.vip.parkinglot.services.TicketService;

public class TicketController {
    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public TicketResponseDto generateTicket(GenerateTicketRequestDto generateTicketRequestDto) {
        TicketResponseDto ticketResponseDto = null;
        try {
            ticketResponseDto = ticketService.generateTicket(generateTicketRequestDto);
        } catch (ParkingSpotNotFoundException | GateNotFoundException e) {
            System.out.print(e.getMessage());
            ticketResponseDto = new TicketResponseDto();
            ticketResponseDto.setTicketStatus(TicketStatus.UNAVAILABLE.getLabel());
        } catch (UnauthorizedEntryGateException e) {
            System.out.print(e.getMessage());
            ticketResponseDto = new TicketResponseDto();
            ticketResponseDto.setTicketStatus(TicketStatus.UNAUTHORIZED.getLabel());
        }
        return ticketResponseDto;
    }
}
