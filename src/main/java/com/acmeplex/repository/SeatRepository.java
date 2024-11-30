package com.acmeplex.repository;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.acmeplex.model.Seat;

@Repository
public class SeatRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Check if a seat exists by row and seat number
    public boolean isSeatExists(int rowNum, int seatNum) {
        String sql = "SELECT COUNT(*) FROM seats WHERE rowNum = ? AND seatNum = ?";
        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{rowNum, seatNum}, Integer.class);
        return count != null && count > 0;
    }

    // Insert a new seat
    public void insertSeat(Seat seat) {
        String sql = "INSERT INTO seats (rowNum, seatNum, isAvailable) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, seat.getRow(), seat.getNumber(), seat.isAvailable());
    }

    // Retrieve all seats
    public List<Seat> getAllSeats() {
        String sql = "SELECT * FROM seats";
        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToSeat(rs));
    }

    // Retrieve a seat by ID
    public Seat getSeatById(int seatId) {
        String sql = "SELECT * FROM seats WHERE seatId = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{seatId}, (rs, rowNum) -> mapRowToSeat(rs));
    }

    // Update a seat's details
    public void updateSeat(Seat seat) {
        String sql = "UPDATE seats SET rowNum = ?, seatNum = ?, isAvailable = ? WHERE seatId = ?";
        jdbcTemplate.update(sql, seat.getRow(), seat.getNumber(), seat.isAvailable(), seat.getId());
    }

    // Update seat availability (for canceling tickets)
    public void updateSeatAvailability(int seatId, boolean isAvailable) {
        String sql = "UPDATE seats SET isAvailable = ? WHERE seatId = ?";
        jdbcTemplate.update(sql, isAvailable, seatId);
    }
    // Delete a seat by ID
    public void deleteSeat(int seatId) {
        String sql = "DELETE FROM seats WHERE seatId = ?";
        jdbcTemplate.update(sql, seatId);
    }

    // Map ResultSet to Seat object
    private Seat mapRowToSeat(ResultSet rs) throws SQLException {
        Seat seat = new Seat();
        seat.setRow(rs.getInt("rowNum"));
        seat.setNumber(rs.getInt("seatNum"));
        seat.setAvailable(rs.getBoolean("isAvailable"));
        return seat;
    }
}





//package com.acmeplex.repository;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import com.acmeplex.model.Seat;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//@Repository
//public class SeatRepository {
//
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    public boolean isSeatExists(int row, int number) {
//        String sql = "SELECT COUNT(*) FROM seats WHERE rowNum = ? AND seatNum = ?";
//        @SuppressWarnings("deprecation")
//        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{row, number}, Integer.class);
//        return count != null && count > 0;
//    }
//
//    // Insert a seat
//    public void insertSeat(Seat seat) {
//        String sql = "INSERT INTO seats (rowNum, seatNum, isAvailable) VALUES (?, ?, ?)";
//        jdbcTemplate.update(sql, seat.getRow(), seat.getNumber(), seat.isAvailable());
//    }
//
//    // Retrieve all seats
//    public List<Seat> getAllSeats() {
//        String sql = "SELECT * FROM seats";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> mapRowToSeat(rs));
//    }
//
//    // Retrieve a seat by ID
//    @SuppressWarnings("deprecation")
//    public Seat getSeatById(int seatId) {
//        String sql = "SELECT * FROM seats WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{seatId}, (rs, rowNum) -> mapRowToSeat(rs));
//    }
//
//    // Update a seat
//    public void updateSeat(Seat seat) {
//        String sql = "UPDATE seats SET rowNum = ?, seatNum = ?, isAvailable = ? WHERE id = ?";
//        jdbcTemplate.update(sql, seat.getRow(), seat.getNumber(), seat.isAvailable(), seat.getId());
//    }
//
//    // Delete a seat
//    public void deleteSeat(int seatId) {
//        String sql = "DELETE FROM seats WHERE id = ?";
//        jdbcTemplate.update(sql, seatId);
//    }
//
//    // Map ResultSet to Seat object
//    private Seat mapRowToSeat(ResultSet rs) throws SQLException {
//        return new Seat(
//            rs.getInt("rowNum"),
//            rs.getInt("seatNum"),
//            rs.getBoolean("isAvailable")
//        );
//    }
//}
//
//
