package org.vip.parkinglot.models.billing;

public enum PaymentStatus {
    SUCCESS("Success"),
    FAILURE("Failure"),
    PENDING("Pending"),
    REFUND("Refund");

    private final String label;

    private PaymentStatus(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}
