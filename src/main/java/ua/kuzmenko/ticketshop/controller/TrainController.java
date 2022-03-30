package ua.kuzmenko.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.kuzmenko.ticketshop.model.Session;
import ua.kuzmenko.ticketshop.model.Train;
import ua.kuzmenko.ticketshop.service.SessionService;
import ua.kuzmenko.ticketshop.service.TrainService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;

@Controller
public class TrainController {
    private final TrainService trainService;
    private final SessionService sessionService;

    @Autowired
    public TrainController(TrainService trainService, SessionService sessionService) {
        this.trainService = trainService;
        this.sessionService = sessionService;
    }

    @GetMapping("/addTrain")
    public String page(Model model) {
        return "addTrain";
    }

    @PostMapping("/addTrain")
    public String addNewTrain(Model model, Train train) {
        trainService.save(train);

        return "redirect:/";
    }

    @GetMapping("/train/{id}")
    public String train(Model model, @PathVariable(name = "id") Train train, @RequestParam(required = false, defaultValue = "") String date) {

        if (!date.equals("")) {
            System.out.println(date);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            LocalDateTime lDate = LocalDateTime.parse(date + " 00:00", formatter);
            System.out.println(lDate);
            model.addAttribute("date", date);
            List<Session> todaySession = this.sessionService.findAllByStartDateBetweenAndTrain(lDate, lDate.plusDays(1), train);


            todaySession.sort(Comparator.comparing(Session::getStartDate));
            model.addAttribute("sessions", todaySession);
        }
        model.addAttribute("train", train);


        return "train";
    }
}
