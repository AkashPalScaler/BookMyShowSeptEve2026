package com.scaler.bmsseptevening2026.DTO;

import com.scaler.bmsseptevening2026.Models.BookingStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookMovieResponseDTO {
    private Long bookingId;
    private Double amount;
    private BookingStatus bookingStatus;
    private String message;
    private ResponseStatus responseStatus;

    // All booking details like theatre, movie, time
}

// Break till 10:04
