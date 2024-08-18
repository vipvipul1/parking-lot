package org.vip.parkinglot.repositories;

import org.vip.parkinglot.models.parking.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    Map<Integer, Gate> gateList = new HashMap<>();

    public Gate getGateByGateNumber(Integer gateNumber) {
        if (gateNumber != null)
            return gateList.get(gateNumber);
        return null;
    }
}
