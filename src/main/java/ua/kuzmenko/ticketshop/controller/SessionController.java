package ua.kuzmenko.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Ticket;
import ua.kuzmenko.ticketshop.model.Train;
import ua.kuzmenko.ticketshop.model.User;
import ua.kuzmenko.ticketshop.service.HallService;
import ua.kuzmenko.ticketshop.service.SessionService;
import ua.kuzmenko.ticketshop.service.TicketService;
import ua.kuzmenko.ticketshop.service.TrainService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Controller
public class SessionController {

    private final SessionService sessionService;
    private final HallService hallService;
    private final TrainService trainService;
    private final TicketService ticketService;

    @Autowired
    public SessionController(SessionService sessionService, HallService hallService, TrainService trainService, TicketService ticketService) {
        this.sessionService = sessionService;
        this.hallService = hallService;
        this.trainService = trainService;
        this.ticketService = ticketService;
    }

    @GetMapping("/addSession")
    public String page(Model model) {
        model.addAttribute("trains", trainService.findAllActive());
        model.addAttribute("halls", hallService.findAll());
        return "addSession";
    }

    @PostMapping("/addSession")
    public String addNewSession(Model model, String trainName, String hallNumber, String date, String time) {

        Session session = new Session();
        Train train = trainService.findByName(trainName);
        session.setTrain(train);
        session.setHall(hallService.findByNumber(hallNumber));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date + " " + time, formatter);

        session.setStartDate(dateTime);

        this.sessionService.save(session);
        return "redirect:/train/" + train.getId() + "?date=" + date;
    }

    @PostMapping("/sessions/delete/{id}")
    public String deleteSession(Model model, @PathVariable(name = "id") Session session, String date) {
        System.out.println("DELETE " + session.getStartDate());
        this.sessionService.delete(session);
        return "redirect:/train/" + session.getTrain().getId() + "?date=" + date;
    }

    @GetMapping("/sessions/{id}")
    public String pageSession(Model model, @PathVariable(name = "id") Session session) {
        model.addAttribute("train", session.getTrain());
        List<Ticket> buyTickets = ticketService.findAllBySession(session);
        buyTickets.sort(Comparator.comparingInt((Ticket f) -> f.getRow() * 4 + f.getSeat()));

        boolean flag = false;
        List<Ticket> tickets = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                for (Ticket t : buyTickets) {
                    if (t.getRow() * 4 + t.getSeat() + t.getRow() == i * 4 + j + i) {
                        tickets.add(t);
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    tickets.add(new Ticket());
                } else {
                    flag = false;
                }
            }
        }

        model.addAttribute("tickets", tickets);
        model.addAttribute("countOfBuyTickets", ticketService.countAllBySession(session));
        model.addAttribute("session", session);

        System.out.println(ticketService.findAllBySession(session).size());
        return "sessions";
    }

    @PostMapping("/sessions/{id}/buy")
    public String buySession(Model model, @PathVariable(name = "id") Session session, String row, String seat) {
        Ticket ticketFromBd = ticketService.findByRowAndSeatAndSession(Integer.parseInt(row) - 1, Integer.parseInt(seat) - 1, session);
        if (ticketFromBd != null) {
            model.addAttribute("message", "Место уже занято!");
            System.out.println("ой");
            return "redirect:/sessions/" + session.getId();
        }
        Ticket ticket = new Ticket();
        ticket.setRow(Integer.parseInt(row) - 1);
        ticket.setSeat(Integer.parseInt(seat) - 1);
        ticket.setSession(session);
        User userPrincipal = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ticket.setUser(userPrincipal);

        ticketService.save(ticket);
        return "redirect:/tickets";
    }
}
