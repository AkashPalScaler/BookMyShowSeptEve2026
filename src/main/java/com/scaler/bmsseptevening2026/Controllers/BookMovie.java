package com.scaler.bmsseptevening2026.Controllers;

import com.scaler.bmsseptevening2026.DTO.BookMovieRequestDTO;
import com.scaler.bmsseptevening2026.DTO.BookMovieResponseDTO;
import com.scaler.bmsseptevening2026.DTO.ResponseStatus;
import com.scaler.bmsseptevening2026.Models.Booking;
import com.scaler.bmsseptevening2026.Services.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// localhost:3000/booking/create
@Controller
public class BookMovie {
//    @Autowired // Field injection
    private BookingService bookingService;

    @Autowired // Constructor injection
    public BookMovie(BookingService bookingService) {
        this.bookingService = bookingService;
    }

//    @Autowired // Setter injection
//    public void setBookingService(BookingService bookingService) {
//        this.bookingService = bookingService;
//    }

    BookMovieResponseDTO movieBooking(BookMovieRequestDTO requestDTO) {
        BookMovieResponseDTO responseDTO = new BookMovieResponseDTO();
        try{
            Booking booking = bookingService.bookMovie(
                    requestDTO.getUserId(),
                    requestDTO.getShowId(),
                    requestDTO.getShowSeatIds());

            responseDTO.setBookingId(booking.getId());
            responseDTO.setAmount(booking.getAmount());
            responseDTO.setBookingStatus(booking.getStatus());
            responseDTO.setMessage("Booking successful");
            responseDTO.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDTO.setMessage("Booking unsuccessful");
            responseDTO.setResponseStatus(ResponseStatus.FAILURE);
        }
        return responseDTO;
    }
}
