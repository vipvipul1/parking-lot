package org.vip.parkinglot.strategies.feecalculation;

import org.vip.parkinglot.models.parking.Ticket;

public interface FeeCalculationStrategy {
    public Integer calculateFee(Ticket ticket);
}
