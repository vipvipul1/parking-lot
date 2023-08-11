package org.vip.parkinglot.dtos;

import org.vip.parkinglot.models.parking.Gate;
import org.vip.parkinglot.models.vehicle.Vehicle;

import java.time.LocalDateTime;

public class TicketResponseDto {
    private Integer ticketNumber;
    private Vehicle vehicle;
    private Gate entryGate;
    private String spotNumber;
    private LocalDateTime entryDateTime;
    private String ticketStatus;

    public Integer getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Integer ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public String getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(String spotNumber) {
        this.spotNumber = spotNumber;
    }

    public LocalDateTime getEntryDateTime() {
        return entryDateTime;
    }

    public void setEntryDateTime(LocalDateTime entryDate) {
        this.entryDateTime = entryDate;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }
}
