package org.vip.parkinglot.services;

import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.repositories.GateRepository;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateByGateNumber(Integer gateNumber) {
        return gateRepository.getGateByGateNumber(gateNumber);
    }
}
