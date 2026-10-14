package com.scaler.bmsseptevening2026.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class BookMovieRequestDTO {
    private Long userId;
    private Long showId; // Theatre, Movie, Timing, Screen
    private List<Long> showSeatIds;
}
