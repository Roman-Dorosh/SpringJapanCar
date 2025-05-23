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
        model.addAttribute("car", new Car());
        return "formNewCar";
    }

    //Добавление объекта в список.
    @PostMapping
    public String openPageAddCar(@RequestParam("model") String model,
                                 @RequestParam("equipment") String equipment,
                                 @RequestParam("yearRelease") int yearRelease,
                                 Model thModel) {

        Car car = new Car();

        car.setModel(model);
        car.setEquipment(equipment);
        car.setYearRelease(yearRelease);

        carsDao.addNewCar(car);

        thModel.addAttribute("pageNewCar", car);

        return "pageNewCar";
    }

    //Отображение формы для обновления объекта.
    @GetMapping("/{id}/editCar")
    public String openPageEditCar(@PathVariable("id") int id, Model model) {
        model.addAttribute("formEditCar", carsDao.findSpecificCar(id));
        return "formEditCar";
    }

    //Обновление объекта.
    @PatchMapping("/{id}/editCar")
    public String openPageUpdateCar(@PathVariable("id") int id,
                                    @RequestParam("model") String model,
                                    @RequestParam("equipment") String equipment,
                                    @RequestParam("yearRelease") int yearRelease) {

        Car car = new Car();

        car.setModel(model);
        car.setEquipment(equipment);
        car.setYearRelease(yearRelease);

        carsDao.updateCar(id, car);

        return "redirect:/{id}";
    }

    // Удаление объекта.
    @DeleteMapping("/{id}")
    public String deleteCar(@PathVariable("id") int id) {
        carsDao.deleteCar(id);
        return "redirect:http://localhost:8080/";
    }
}