package org.vip.parkinglot.services;

import org.vip.parkinglot.models.vehicle.Vehicle;
import org.vip.parkinglot.models.vehicle.VehicleType;
import org.vip.parkinglot.repositories.VehicleRepository;

public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle getVehicleByVehicleNumber(String vehicleNumber) {
        return vehicleRepository.getVehicleByVehicleNumber(vehicleNumber);
    }

    public Vehicle registerVehicle(String vehicleNumber, VehicleType vehicleType) {
        return vehicleRepository.registerVehicle(vehicleNumber, vehicleType);
    }
}
