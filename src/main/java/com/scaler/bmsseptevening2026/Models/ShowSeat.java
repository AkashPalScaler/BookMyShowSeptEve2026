package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends BaseModel{
    // ShowSeat M:1 Show
    @ManyToOne
    private Show  show;
    @ManyToOne
    private Seat seat;
    @Enumerated(EnumType.STRING)
    private ShowSeatStatus status;
    @ManyToOne
    private Booking booking;
}
// Booking 1:M ShowSeat