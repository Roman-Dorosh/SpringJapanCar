package ru.japan.car;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller()
public class CarController {

    @GetMapping()
    public String mainCar() {
        return "main";
    }

    @GetMapping("/chaser")
    public String chaser() {
        return "chaser";
    }

    @GetMapping("/mark")
    public String mark() {
        return "mark";
    }
}