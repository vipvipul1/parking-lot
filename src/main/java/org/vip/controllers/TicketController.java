package org.vip.controllers;

import org.vip.dtos.GenerateTicketRequestDto;
import org.vip.dtos.TicketResponseDto;
import org.vip.exceptions.GateNotFoundException;
import org.vip.exceptions.ParkingSpotNotFoundException;
import org.vip.exceptions.UnauthorizedEntryGateException;
import org.vip.models.billing.TicketStatus;
import org.vip.services.TicketService;

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
