package com.scaler.bmsseptevening2026.Services;

import com.scaler.bmsseptevening2026.Models.*;
import com.scaler.bmsseptevening2026.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.*;

@Service
public class BookingService {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowSeatTypeRepository showSeatTypeRepository;
    @Autowired
    public BookingService(UserRepository userRepository, BookingRepository bookingRepository, ShowRepository showRepository, ShowSeatRepository showSeatRepository, ShowSeatTypeRepository showSeatTypeRepository) {
        this.userRepository = userRepository;
        this.bookingRepository = bookingRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.showSeatTypeRepository = showSeatTypeRepository;
    }


    public Booking bookMovie(Long userId, Long showId, List<Long> showSeatIds){
        // TODO: Booking creation logic
        // Fetch the user from userId and validate
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid user ID"));
        // Fetch the show from showId and validate
        Show show = showRepository.findById(showId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid show ID"));

        // ----------- Transaction starts ---------------
        List<ShowSeat> savedShowSeats = reserveSeats(showSeatIds);
        // ----------- Transaction ends ---------------

        // Calculate the pricing
        Map<SeatType, Double> showSeatPriceMap = new HashMap<>();
        List<ShowSeatType> showSeatTypes = showSeatTypeRepository.findAllByShow_Id(showId);
        for(ShowSeatType showSeatType : showSeatTypes){
            showSeatPriceMap.put(showSeatType.getSeatType(), showSeatType.getPrice());
        }
        Double amount = 0.0;
        for(ShowSeat showSeat : savedShowSeats){
            amount += showSeatPriceMap.get(showSeat.getSeat().getSeatType());
        }

        // Create and return the booking
        Booking booking = new Booking();
        booking.setShow(show);
        booking.setShowSeats(savedShowSeats);
        booking.setAmount(amount);
        booking.setStatus(BookingStatus.PENDING);
        booking.setUser(user);
        return bookingRepository.save(booking);
    }
    @Transactional(isolation = Isolation.SERIALIZABLE) //
    List<ShowSeat> reserveSeats(List<Long> showSeatIds){
        // Fetch the showSeats from showSeatIds and validate
        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);
        // Check the availability of the showSeats
        //   if -> available : then update the status of the showSeat to Blocked and update the blockedAt time
        //   else if -> booked : then throw exception
        //   else if -> blocked :
        //          if (curr_time - blockedAt > waitDuration): update the blockedAt time
        //          else : throw exception
        for(ShowSeat showSeat : showSeats){
            Boolean isAvailable = showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE);
            Boolean isBlockExpired =  showSeat.getStatus().equals(ShowSeatStatus.BLOCKED) &&
                    Duration.between(showSeat.getBlockedAt().toInstant(), new Date().toInstant()).toMinutes() > 15;
            if(!(isAvailable || isBlockExpired)){
                throw new IllegalArgumentException("Seat is already blocked or booked, please try again later");
            }
        }
        List<ShowSeat> savedShowSeats = new ArrayList<>();

        // Save the updates of showSeats
        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.BLOCKED);
            showSeat.setBlockedAt(new Date());
            savedShowSeats.add(showSeat);
        }
        return showSeatRepository.saveAll(savedShowSeats);
    }


}

// Break till 10:06 AM