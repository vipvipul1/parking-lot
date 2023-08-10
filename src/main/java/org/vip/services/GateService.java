package org.vip.services;

import org.vip.models.parking.Gate;
import org.vip.repositories.GateRepository;

import java.util.HashMap;
import java.util.Map;

public class GateService {
    private GateRepository gateRepository;

    public GateService(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    public Gate getGateByGateNumber(Integer gateNumber) {
        return gateRepository.getGateByGateNumber(gateNumber);
    }
}
