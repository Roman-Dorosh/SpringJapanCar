package ru.japan.car.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class CarControllers {

    @GetMapping()
    public String mainCar() {
        return "main";
    }

    @GetMapping("/chaser")
    public String chaser
            (@RequestParam(value = "equipment", required = false) String equipment,
             @RequestParam(value = "release", required = false) String release,
             @RequestParam(value = "engine", required = false) String engine,
             @RequestParam(value = "volume", required = false) String volume,
             @RequestParam(value = "power", required = false) String power,
             @RequestParam(value = "expenditure", required = false) String expenditure,
             Model model) {

        model.addAttribute("equipment", equipment);
        model.addAttribute("release", release);
        model.addAttribute("engine", engine);
        model.addAttribute("volume", volume);
        model.addAttribute("power", power);
        model.addAttribute("expenditure", expenditure);


        return "chaser";
    }

    @GetMapping("/mark")
    public String mark
            (@RequestParam(value = "equipment", required = false) String equipment,
             @RequestParam(value = "release", required = false) String release,
             @RequestParam(value = "engine", required = false) String engine,
             @RequestParam(value = "volume", required = false) String volume,
             @RequestParam(value = "power", required = false) String power,
             @RequestParam(value = "expenditure", required = false) String expenditure,
             Model model) {

        model.addAttribute("equipment", equipment);
        model.addAttribute("release", release);
        model.addAttribute("engine", engine);
        model.addAttribute("volume", volume);
        model.addAttribute("power", power);
        model.addAttribute("expenditure", expenditure);


        return "mark";
    }
}