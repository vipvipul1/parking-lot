package org.vip.repositories;

import org.vip.models.billing.Ticket;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap = new HashMap<>();

    public void saveTicket(Ticket ticket) {
        ticket.setTicketId(UUID.randomUUID().hashCode());
        ticketMap.put(ticket.getTicketNumber(), ticket);
    }
}
