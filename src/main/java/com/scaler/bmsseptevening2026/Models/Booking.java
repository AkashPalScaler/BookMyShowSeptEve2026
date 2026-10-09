package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Entity
public class Booking extends BaseModel{
    // Booking M:1 User
    @ManyToOne
    private User user;

    // Booking 1:M ShowSeat
    @OneToMany(mappedBy = "booking")
    private List<ShowSeat> showSeats;
    private Double amount;
    // Booking M:1 Show
    @ManyToOne
    private Show show;
    @OneToMany(mappedBy = "booking")
    private List<Payment> payments;
    @Enumerated(EnumType.STRING)
    private BookingStatus status;
}
// Setters, Getters, Formatters