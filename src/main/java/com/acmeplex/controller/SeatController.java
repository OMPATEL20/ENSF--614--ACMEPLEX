package com.acmeplex.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acmeplex.model.Seat;
import com.acmeplex.service.EmailService;
import com.acmeplex.service.PaymentService;
import com.acmeplex.service.SeatService;
import com.acmeplex.service.TicketcancelService;

@RestController
@RequestMapping
public class SeatController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private EmailService emailService;

    @Autowired
    private SeatService seatService;

    @Autowired
    private TicketcancelService ticketcancelService;

    @GetMapping("/CancelForm")
    public String cancelForm() {
        return "CancelForm";
    }

    @GetMapping("/confirmCancellation")
    public String Confirm() {
        return "CancelConfirmation";
    }

    @PostMapping("/processCancel")
    public String processCancelTicket(@RequestParam String email, Model model) {
        // Call service to cancel tickets
        Map<String, Object> result = ticketcancelService.getUserTickets(email);

        // Add result to model for display
        model.addAttribute("payments", result.get("payments"));
        model.addAttribute("seats", result.get("seats"));

        // Return the same page
        return "CancelForm";
    }

    @PostMapping("/deletePayment")
    public String deletePayment(@RequestParam Long paymentId, @RequestParam String email, Model model) {
        // Delete the payment using the paymentId
        paymentService.deletePayment(paymentId);

        // Fetch updated tickets for the user
        Map<String, Object> result = ticketcancelService.getUserTickets(email);
        model.addAttribute("payments", result.get("payments"));
        model.addAttribute("seats", result.get("seats"));

        // Reload the cancel-ticket page
        return "cancelForm";
    }

}
