package ru.japan.car.dao;

import org.springframework.stereotype.Component;
import ru.japan.car.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class CarsDAO {

    private static final String URL = "jdbc:postgresql://localhost:5432/cars_db";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    private static Connection connection;

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Список объектов.
    public List<Car> listCar() {
        List<Car> cars = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Cars";
            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Car car = new Car();

                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setEquipment(resultSet.getString("equipment"));
                car.setYearRelease(resultSet.getInt("yearrelease"));

                cars.add(car);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cars;
    }

    // Поиск объекта.
    public Car findSpecificCar(int id) {
        Car car = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM Cars WHERE id = ?");

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            car = new Car();

            car.setId(resultSet.getInt("id"));
            car.setModel(resultSet.getString("model"));
            car.setEquipment(resultSet.getString("equipment"));
            car.setYearRelease(resultSet.getInt("yearrelease"));


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return car;
    }

    // Добавление объекта.
    public void addNewCar(Car newCar) {
        try {
            PreparedStatement preparedStatement = preparedStatement = connection.prepareStatement("INSERT INTO Cars VALUES (8, ?, ?, ?)");

            preparedStatement.setString(1, newCar.getModel());
            preparedStatement.setString(2, newCar.getEquipment());
            preparedStatement.setInt(3, newCar.getYearRelease());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Обновление объекта.
    public void updateCar(int id, Car carUpdate) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE Cars SET model = ?, equipment = ?, yearrelease = ? WHERE id = ?");

            preparedStatement.setString(1, carUpdate.getModel());
            preparedStatement.setString(2, carUpdate.getEquipment());
            preparedStatement.setInt(3, carUpdate.getYearRelease());
            preparedStatement.setInt(4, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    // Удаление объекта.
    public void deleteCar(int id) {
        try {
            PreparedStatement preparedStatement = preparedStatement = connection.prepareStatement("DELETE FROM Cars WHERE id = ?");
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}