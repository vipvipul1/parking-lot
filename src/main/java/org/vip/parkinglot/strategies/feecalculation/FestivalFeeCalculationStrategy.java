package org.vip.parkinglot.strategies.feecalculation;

import org.vip.parkinglot.models.parking.Ticket;

// Returns the Fee based on Festival Fee configured in db.
public class FestivalFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public Integer calculateFee(Ticket ticket) {
        return null;
    }
}
