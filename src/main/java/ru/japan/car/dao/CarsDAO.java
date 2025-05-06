package ru.japan.car.dao;

import org.springframework.stereotype.Component;
import ru.japan.car.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDAO {
    private List<Car> car;
    private static int ID;

    {
        car = new ArrayList<>();

        car.add(new Car(++ID, 1999, "Tourer-V", "Toyota Chaser"));
        car.add(new Car(++ID, 1996, "Tourer-S", "Toyota Mark II"));
        car.add(new Car(++ID, 2002, "Spec-R-V-package", "Nissan Silvia"));
        car.add(new Car(++ID, 2001, "25GT turbo", "Nissan Skyline"));
        car.add(new Car(++ID, 2009, "MT Premium Pack", "Nissan 350Z"));

    }

    public List<Car> listCar() {
        return car;
    }

    public Car findSpecificCar(int id) {
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).getId() == id) {
                return car.get(i);
            }
        }
        return null;
    }

    public void addNewCar(Car newCar){
        newCar.setId(++ID);
        car.add(newCar);
    }
}