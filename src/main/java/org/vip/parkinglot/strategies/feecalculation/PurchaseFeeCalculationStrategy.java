package org.vip.parkinglot.strategies.feecalculation;

import org.vip.parkinglot.models.parking.Ticket;

// - Returns Fee based on purchase of user using a mapping table between purchaseId & ticketId.
// - During purchase, an entry of purchaseId & ticketId will be done by Purchase Billing System
// in the mapping table when user shares the ticket to the Purchase Billing Agent.
public class PurchaseFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public Integer calculateFee(Ticket ticket) {
        return null;
    }
}
