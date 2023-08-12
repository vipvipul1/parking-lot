package org.vip.parkinglot.strategies.feecalculation;

import org.vip.parkinglot.models.parking.Ticket;

// Returns the Dynamic Fee based on Duration spent using DurationBasedPriceRate table.
public class DurationFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public Integer calculateFee(Ticket ticket) {
        return null;
    }
}
