package org.vip.repositories;

import org.vip.models.vehicle.Vehicle;
import org.vip.models.vehicle.VehicleType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VehicleRepository {
    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicle getVehicleByVehicleNumber(String vehicleNumber) {
        return vehicleMap.get(vehicleNumber);
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        Vehicle newVehicle = new Vehicle();
        newVehicle.setVehicleId(UUID.randomUUID().hashCode());
        newVehicle.setVehicleNumber(vehicleNumber);
        newVehicle.setVehicleType(vehicleType);
        return newVehicle;
    }
}
