package ru.japan.car.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.japan.car.dao.CarsDAO;
import ru.japan.car.model.Car;

@Controller()
public class CarControllers {

    private final CarsDAO carsDao;

    @Autowired
    public CarControllers(CarsDAO carsDAO) {
        this.carsDao = carsDAO;
    }

    //Отображение всех объектов на странице.
    @GetMapping
    public String mainPageCar(Model model) {
        model.addAttribute("listCar", carsDao.listCar());
        return "listCar";
    }

    //Отображение определенного объекта на странице.
    @GetMapping("/{id}")
    public String openPageCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("openCar", carsDao.findSpecificCar(id));
        return "openCars";
    }

    //Отображение формы для создания объекта.
    @GetMapping("/newCar")
    public String openPageNewCar(Model model) {
        model.addAttribute("newCar", new Car());
        return "formNewCar";
    }

    //@GetMapping("/newCar")
    //public String openPageNewCar(@ModelAttribute("newCar") Car car) {
    //    return "formNewCar";
    //}
    //
    //@PostMapping
    //public String openPageAddCar(@ModelAttribute("addNewCar") Car car) {
    //    carsDao.addNewCar(car);
    //    return "redirect:http://localhost:8080/";
    // }

    //Добавление объекта в список.
    @PostMapping
    public String openPageAddCar(@RequestParam("model") String model,
                                 @RequestParam("equipment") String equipment,
                                 @RequestParam("yearRelease") int yearRelease) {

        Car car = new Car();

        car.setModel(model);
        car.setEquipment(equipment);
        car.setYearRelease(yearRelease);

        carsDao.addNewCar(car);

        return "redirect:http://localhost:8080/";
    }
}