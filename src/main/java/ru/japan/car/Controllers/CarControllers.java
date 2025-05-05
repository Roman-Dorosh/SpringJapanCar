package ru.japan.car.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.japan.car.dao.CarsDAO;

@Controller()
public class CarControllers {

    private final CarsDAO carsDao;

    @Autowired
    public CarControllers(CarsDAO carsDAO) {
        this.carsDao = carsDAO;
    }

    @GetMapping
    public String mainPageCar(Model model) {
        model.addAttribute("listCar", carsDao.listCar());
        return "mainPage";
    }

    @GetMapping("/{id}")
    public String openPageCars(@PathVariable("id") int id, Model model) {
        model.addAttribute("openCar", carsDao.openCar(id));
        return "openCars";
    }
}