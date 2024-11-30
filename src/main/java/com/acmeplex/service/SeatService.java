package com.acmeplex.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.acmeplex.model.Seat;
import com.acmeplex.repository.SeatRepository;

@Service
public class SeatService {

    private final SeatRepository seatRepository;

    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    // Add a new seat
    public void addSeat(Seat seat) {
        if (!seatRepository.isSeatExists(seat.getRow(), seat.getNumber())) {
            seatRepository.insertSeat(seat);
        } else {
            throw new IllegalArgumentException("Seat already exists at row: " + seat.getRow() + ", seat: " + seat.getNumber());
        }
    }

    // Get all seats
    public List<Seat> getAllSeats() {
        return seatRepository.getAllSeats();
    }

    // Get a seat by ID
    public Seat getSeatById(int seatId) {
        Seat seat = seatRepository.getSeatById(seatId);
        if (seat == null) {
            throw new IllegalArgumentException("Seat with ID " + seatId + " does not exist.");
        }
        return seat;
    }

    // Update a seat
    public void updateSeat(Seat seat) {
        if (seatRepository.isSeatExists(seat.getRow(), seat.getNumber())) {
            seatRepository.updateSeat(seat);
        } else {
            throw new IllegalArgumentException("Seat does not exist for update.");
        }
    }

    // Delete a seat
    public void deleteSeat(int seatId) {
        Seat seat = getSeatById(seatId); // Ensure seat exists
        seatRepository.deleteSeat(seatId);
    }

    // Generate a seat map for rows and numbers
    public Map<Integer, List<Seat>> generateSeatMap() {
        Map<Integer, List<Seat>> seatMap = new HashMap<>();

        for (int row = 1; row <= 8; row++) { // Assume 8 rows for simplicity
            List<Seat> seats = new ArrayList<>();
            for (int number = 1; number <= 10; number++) { // Assume 10 seats per row
                boolean isAvailable = !seatRepository.isSeatExists(row, number);
                seats.add(new Seat(row, number, isAvailable));
            }
            seatMap.put(row, seats);
        }

        return seatMap;
    }

    // Transform selected seat strings into Seat objects
//    public List<Seat> transformSelectedSeats(String selectedSeats) {
//        List<Seat> seats = new ArrayList<>();
//
//        // Split the input by commas to get individual seat strings
//        String[] seatArray = selectedSeats.split(",");
//
//        for (String seatInfo : seatArray) {
//            // Split each seat string by '-' to extract row and seat number
//            String[] parts = seatInfo.split("-");
//            int row = Integer.parseInt(parts[0].substring(1)); // Remove 'R' and parse the row number
//            int number = Integer.parseInt(parts[1].substring(1)); // Remove 'S' and parse the seat number
//
//            // Create a Seat object with default availability as true
//            seats.add(new Seat(row, number, true));
//        }
//
//        return seats;
//    }

    // Update seat availability for multiple seats
    public void updateSeatAvailability(List<Integer> seatIds, boolean isAvailable) {
        for (int seatId : seatIds) {
            Seat seat = getSeatById(seatId); // Ensure seat exists
            seatRepository.updateSeatAvailability(seatId, isAvailable);
        }
    }

    // Get seats by showtime (requires extending repository)
    public List<Seat> getSeatsByShowtime(Long showtimeId) {
        // This requires a method like `findByShowtimeId` in the repository
        throw new UnsupportedOperationException("Method not implemented yet.");
    }
 // Cancel a ticket by seat ID
    public boolean cancelSeats(List<Seat> seatsToCancel) {
        for (Seat seat : seatsToCancel) {
            // Update seat availability to true (available)
            seatRepository.updateSeatAvailability(seat.getId(), true);
        }
		return false;
    }
    public List<Seat> transformSelectedSeats(String selectedSeats) {
        List<Seat> seats = new ArrayList<>();
        String[] seatArray = selectedSeats.split(",");

        for (String seatInfo : seatArray) {
            String[] parts = seatInfo.split("-");
            int row = Integer.parseInt(parts[0].substring(1)); // Remove 'R' and parse the row number
            int number = Integer.parseInt(parts[1].substring(1)); // Remove 'S' and parse the seat number

            // Create a Seat object and add it to the list
            Seat seat = new Seat();
            seat.setRow(row);
            seat.setNumber(number);
            seats.add(seat);
        }

        return seats;
    }
}



//package com.acmeplex.service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import org.springframework.stereotype.Service;
//
//import com.acmeplex.model.Seat;
//import com.acmeplex.repository.SeatRepository;
//
//@Service
//public class SeatService {
//
//    private final SeatRepository seatRepository;
//
//    public SeatService(SeatRepository seatRepository) {
//        this.seatRepository = seatRepository;
//    }
//
//    // Add a new seat
//    public void addSeat(Seat seat) {
//        seatRepository.insertSeat(seat);
//    }
//
//    // Get all seats
//    public List<Seat> getAllSeats() {
//        return seatRepository.getAllSeats();
//    }
//
//    // Get a seat by ID
//    public Seat getSeatById(int seatId) {
//        return seatRepository.getSeatById(seatId);
//    }
//
//    // Update a seat
//    public void updateSeat(Seat seat) {
//        seatRepository.updateSeat(seat);
//    }
//
//    // Delete a seat
//    public void deleteSeat(int seatId) {
//        seatRepository.deleteSeat(seatId);
//    }
//
//    public Map<Integer, List<Seat>> generateSeatMap() {
//        Map<Integer, List<Seat>> seatMap = new HashMap<>();
//
//        for (int row = 1; row <= 8; row++) {
//            List<Seat> seats = new ArrayList<>();
//            for (int number = 1; number <= 10; number++) {
//                // Check if the seat exists in the database
//                boolean isAvailable = !seatRepository.isSeatExists(row, number);
//                seats.add(new Seat(row, number, isAvailable));
//            }
//            seatMap.put(row, seats);
//        }
//
//        return seatMap;
//    }
//
//    public List<Seat> transformSelectedSeats(String selectedSeats) {
//        List<Seat> seats = new ArrayList<>();
//
//        // Split the string by comma to get individual seat positions
//        String[] seatArray = selectedSeats.split(",");
//
//        for (String seatInfo : seatArray) {
//            // Split each seat by '-' to extract row and seat number
//            String[] parts = seatInfo.split("-");
//
//            // Extract row and seat number
//            int row = Integer.parseInt(parts[0].substring(1)); // Remove 'R' and parse the number
//            int number = Integer.parseInt(parts[1].substring(1)); // Remove 'S' and parse the number
//
//            // Create a Seat object and add it to the list
//            seats.add(new Seat(row, number, true));
//        }
//
//        return seats;
//    }
//}

