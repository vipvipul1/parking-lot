package org.vip.parkinglot.repositories;

import org.vip.parkinglot.models.parking.Ticket;
import org.vip.parkinglot.strategies.spotassignment.UserParkingPreference;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TicketRepository {
    private Map<Integer, Ticket> ticketMap = new HashMap<>();

    public void saveTicket(Ticket ticket) {
        ticket.setTicketId(UUID.randomUUID().hashCode());
        ticketMap.put(ticket.getTicketNumber(), ticket);
    }

    public void saveUserParkingPreference(UserParkingPreference userParkingPreference) {
//         save userParkingPreference to db.
    }
}
