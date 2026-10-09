package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
public class Payment extends BaseModel {
    private Double amount;
    // Payment: Booking
    @ManyToOne
    private Booking booking;
    @Enumerated(EnumType.STRING)
    private PaymentMode mode;
    @Enumerated(EnumType.STRING)
    private PaymentStatus status;
    private Date paymentTime;
}
