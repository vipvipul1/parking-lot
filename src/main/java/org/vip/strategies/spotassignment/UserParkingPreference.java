package org.vip.strategies.spotassignment;

import org.vip.models.parking.Gate;
import org.vip.models.parking.ParkingFloor;
import org.vip.models.vehicle.VehicleType;

public class UserParkingPreference {
    private VehicleType vehicleType;
    private Gate entryGate;
    private Gate preferredExitGate;
    private ParkingFloor preferredFloor;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Gate getPreferredExitGate() {
        return preferredExitGate;
    }

    public void setPreferredExitGate(Gate preferredExitGate) {
        this.preferredExitGate = preferredExitGate;
    }

    public ParkingFloor getPreferredFloor() {
        return preferredFloor;
    }

    public void setPreferredFloor(ParkingFloor preferredFloor) {
        this.preferredFloor = preferredFloor;
    }
}
