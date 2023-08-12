package org.vip.parkinglot.strategies.spotassignment;

import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.models.parking.ParkingFloor;
import org.vip.parkinglot.models.parking.Ticket;
import org.vip.parkinglot.models.vehicle.VehicleType;

public class UserParkingPreference {
    private Integer userParkingPreferenceId;
    private Ticket ticket;
    private VehicleType vehicleType;
    private Gate entryGate;
    private Gate preferredExitGate;
    private ParkingFloor preferredFloor;

    public Integer getUserParkingPreferenceId() {
        return userParkingPreferenceId;
    }

    public void setUserParkingPreferenceId(Integer userParkingPreferenceId) {
        this.userParkingPreferenceId = userParkingPreferenceId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

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
