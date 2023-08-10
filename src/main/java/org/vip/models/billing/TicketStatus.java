package org.vip.models.billing;

public enum TicketStatus {
    CONFIRMED("Confirmed"),
    CANCELLED("Cancelled"),
    UNAVAILABLE("Unavailable"),
    UNAUTHORIZED("Unauthorized");

    private final String label;

    TicketStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
