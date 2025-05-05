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

        car.add(new Car(++ID, "Toyota Chaser", 600));
        car.add(new Car(++ID, "Toyota Mark II", 200));
        car.add(new Car(++ID, "Nissan Silvia", 440));
        car.add(new Car(++ID, "Nissan Skyline", 280));
        car.add(new Car(++ID, "Nissan 350Z", 320));

    }

    public List<Car> listCar() {
        return car;
    }

    public Car openCar(int id) {
        for (int i = 0; i < car.size(); i++) {
            if (car.get(i).getId() == id) {
                return car.get(i);
            }
        }
        return null;
    }
}