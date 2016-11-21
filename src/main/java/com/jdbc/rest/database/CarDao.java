package com.jdbc.rest.database;

import com.jdbc.rest.domain.Car;

import java.sql.*;
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

}
