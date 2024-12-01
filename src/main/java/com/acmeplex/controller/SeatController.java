// package com.acmeplex.controller;

// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// import com.acmeplex.model.Seat;
// import com.acmeplex.service.SeatService;

// @RestController
// @RequestMapping
// public class SeatController {

//     @Autowired
//     private SeatService seatService;

//     @PostMapping("/cancel")
//     public ResponseEntity<Map<String, String>> cancelSeats(
//         @RequestParam String theater,
//         @RequestParam String movie,
//         @RequestParam String showTime,
//         @RequestParam String selectedSeats) {
        
//         Map<String, String> response = new HashMap<>();
        
//         try {
//             List<Seat> seatsToCancel = seatService.transformSelectedSeats(selectedSeats);
//             boolean cancellationSuccess = seatService.cancelSeats(seatsToCancel);
            
//             if (cancellationSuccess) {
//                 response.put("status", "success");
//                 response.put("message", "Tickets canceled successfully!");
//                 return ResponseEntity.ok(response);
//             } else {
//                 response.put("status", "error");
//                 response.put("message", "Tickets could not be canceled.");
//                 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//             }
//         } catch (Exception e) {
//             response.put("status", "error");
//             response.put("message", "Error canceling tickets: " + e.getMessage());
//             return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
//         }
//     }


// }
