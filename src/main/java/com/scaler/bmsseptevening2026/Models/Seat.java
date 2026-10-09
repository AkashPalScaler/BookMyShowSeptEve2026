package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String number;
    // SEAT M:1 SeatType
    @ManyToOne
    private SeatType seatType;
    @Column(name="seat_row")
    private Integer row;
    @Column(name="seat_column")
    private Integer column;
    // Seat M:1 Screen
    @ManyToOne
    private Screen screen;
    @Enumerated(EnumType.STRING)
    private SeatStatus status;
}
