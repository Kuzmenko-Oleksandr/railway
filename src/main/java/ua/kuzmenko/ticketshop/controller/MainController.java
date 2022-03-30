package ua.kuzmenko.ticketshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.kuzmenko.ticketshop.service.TrainService;

@Controller
public class MainController {
    private final TrainService trainService;


    @Autowired
    public MainController(TrainService trainService) {
        this.trainService = trainService;
    }

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("trains", trainService.findAllActive());
        return "main";
    }

}
