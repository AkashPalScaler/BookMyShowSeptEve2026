package com.scaler.bmsseptevening2026.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeatType extends BaseModel {
    // ShowSeatType : Show
    @ManyToOne
    private Show show;
    @ManyToOne
    private SeatType seatType;
    private Double price;
}
// Break till : 10:10 AM