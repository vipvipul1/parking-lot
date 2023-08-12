package org.vip.parkinglot.strategies.feecalculation;

import org.vip.parkinglot.models.parking.Ticket;

// Returns the Flat Fee based on ticket.vehicle.vehicleType.
public class FlatFareFeeCalculationStrategy implements FeeCalculationStrategy {
    @Override
    public Integer calculateFee(Ticket ticket) {
        return null;
    }
}
