package com.jdbc.rest.database;

import com.jdbc.rest.domain.Car;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by stas on 20.11.16.
 */
public class CarDao {

    public List<Car> getAllCars(Connection connection) {
        List<Car> cars = new ArrayList<Car>();

        String queryString = "SELECT * FROM CARS";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(queryString);
            while(resultSet.next()) {
                cars.add(new Car(
                        resultSet.getString("model"),
                        resultSet.getString("producer"),
                        resultSet.getDouble("engine_volume"),
                        resultSet.getInt("serial_id"),
                        resultSet.getInt("customer_id"),
                        resultSet.getString("color"),
                        resultSet.getDate("production_date").toLocalDate()));
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cars;
    }


    public void addNewCar(Connection connection, String model, String producer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CARS (" +
                    "model, producer, color, engine_volume, production_date, customer_id, serial_id) VALUES (?,?,?,?,?,?,?)");
            preparedStatement.setString(1, model);
            preparedStatement.setString(2, producer);
            preparedStatement.setString(3, "none");
            preparedStatement.setDouble(4, 1.0);
            preparedStatement.setDate(5, Date.valueOf(LocalDate.now()));
            preparedStatement.setInt(6, 1);
            preparedStatement.setInt(7, 2213);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void editExistedCar(Connection connection, String color, String producer) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE CARS SET color=? WHERE producer=?");
            preparedStatement.setString(1, color);
            preparedStatement.setString(2, producer);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteExistedCarsByColor(Connection connection, String color) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM CARS WHERE color=?");
            preparedStatement.setString(1, color);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
