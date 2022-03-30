package ua.kuzmenko.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.service.TicketService;

@Controller
public class TicketController {
    private final TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public String getTickets(Model model) {
        User userPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println(userPrincipal.getFirstName());
        model.addAttribute("tickets", this.ticketService.findAllByUser(userPrincipal));
        return "tickets";
    }
}
