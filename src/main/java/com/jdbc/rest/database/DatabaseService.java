package com.jdbc.rest.database;

import com.jdbc.rest.domain.Car;
import com.jdbc.rest.domain.Customer;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stas on 20.11.16.
 */
public class DatabaseService {

    private static boolean isDatabaseInitialized;

    private final String DATABASE_URL = "jdbc:mysql://localhost:3306/carshop?useSSL=false";

    private final String USER_NAME = "root";
    private final String PASSWORD = "root";

    public void fillCarShopData() {
        if (!isDatabaseInitialized) {

            Connection connection = openConnection();

            try {
                Statement statement = connection.createStatement();

                String dropCarsTableSqlRequest = "DROP TABLE IF EXISTS CARS";
                statement.executeUpdate(dropCarsTableSqlRequest);

                String dropCustomersTableSqlRequest = "DROP TABLE IF EXISTS CUSTOMERS";
                statement.executeUpdate(dropCustomersTableSqlRequest);

                String createCustomersTableSqlRequest = "CREATE TABLE CUSTOMERS (" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR (15) NOT NULL)";
                statement.executeUpdate(createCustomersTableSqlRequest);

                addCustomersToDatabase(connection);

                String createCarsTableSqlRequest = "CREATE TABLE CARS (" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "serial_id INTEGER, " +
                        "producer VARCHAR (15) NOT NULL, " +
                        "model VARCHAR (20) NOT NULL, " +
                        "color  VARCHAR (10) NOT NULL, " +
                        "engine_volume DECIMAL (2,1) NOT NULL, " +
                        "production_date DATE NOT NULL, " +
                        "customer_id INTEGER NOT NULL" +
                        ")";
                statement.executeUpdate(createCarsTableSqlRequest);

                addCarsToDatabase(connection);

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            isDatabaseInitialized = true;
        }
    }

    public List<Car> getAllCars() {
        Connection connection = openConnection();
        CarDao carDao = new CarDao();
        return carDao.getAllCars(connection);
    }

    private Connection openConnection() {
        Connection dbConnection = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            dbConnection = DriverManager.getConnection(DATABASE_URL, USER_NAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return dbConnection;
    }

    private void addCarsToDatabase(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CARS (" +
                    "model, producer, color, engine_volume, production_date, customer_id, serial_id) VALUES (?,?,?,?,?,?,?)");

            for(Car car: createCars()) {
                try {
                    preparedStatement.setString(1, car.getModel());
                    preparedStatement.setString(2, car.getProducer());
                    preparedStatement.setString(3, car.getColor());
                    preparedStatement.setDouble(4, car.getEngineVolume());
                    preparedStatement.setDate(5, Date.valueOf(car.getDayOfProduction()));
                    preparedStatement.setInt(6, car.getCustomerId());
                    preparedStatement.setInt(7, car.getSerialId());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//            createCars().stream().forEach(car -> {
//                try {
//                    preparedStatement.setString(1, car.getModel());
//                    preparedStatement.setString(2, car.getProducer());
//                    preparedStatement.setString(3, car.getColor());
//                    preparedStatement.setDouble(4, car.getEngineVolume());
//                    preparedStatement.setDate(5, Date.valueOf(car.getDayOfProduction()));
//                    preparedStatement.setInt(6, car.getCustomerId());
//                    preparedStatement.setInt(7, car.getSerialId());
//                    preparedStatement.executeUpdate();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            });
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void addCustomersToDatabase(Connection connection) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO CUSTOMERS " +
                    "(name) VALUES (?)");

            for(Customer customer: createCustomers()) {
                try {
                    preparedStatement.setString(1, customer.getName());
                    preparedStatement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
//            createCustomers().stream()
//                    .map(Customer::getName)
//                    .forEach(name -> {
//                        try {
//                            preparedStatement.setString(1, name);
//                        } catch (SQLException e) {
//                            e.printStackTrace();
//                        }
//                    });
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Car> createCars() {
        return Arrays.asList(
                new Car("modelB", "Volkswagen", 1.9, 1345, 3, "white", LocalDate.now().minus(456, ChronoUnit.DAYS)),
                new Car("modelC", "Sang Young", 1.5, 21323, 2, "pink", LocalDate.now().minus(32, ChronoUnit.DAYS)),
                new Car("modelD", "Mitsubishi", 2.5, 111, 3, "yellow", LocalDate.now().minus(45, ChronoUnit.DAYS)),
                new Car("modelB", "Honda", 0.5, 35, 1, "yellow", LocalDate.now().minus(10099, ChronoUnit.DAYS)),
                new Car("modelB", "Ferrari", 0.6, 1235, 2, "black", LocalDate.now().minus(45, ChronoUnit.DAYS)),
                new Car("modelC", "Mercedes", 9.6, 156, 3, "brown", LocalDate.now().minus(65, ChronoUnit.DAYS)),
                new Car("modelA", "Deawoo", 1.8, 567, 2, "brown", LocalDate.now().minus(144, ChronoUnit.DAYS)),
                new Car("modelB", "Geely", 2.6, 123, 2, "orange", LocalDate.now().minus(14, ChronoUnit.DAYS)),
                new Car("modelC", "Skoda", 1.1, 5951, 3, "white", LocalDate.now().minus(12, ChronoUnit.DAYS)),
                new Car("modelA", "Toyota", 1.6, 1, 1, "black", LocalDate.now().minus(100, ChronoUnit.DAYS)),
                new Car("modelB", "McLaren", 2.5, 11, 1, "blue", LocalDate.now().minus(26, ChronoUnit.DAYS)),
                new Car("modelB", "Kia", 1.6, 4545, 2, "grey", LocalDate.now().minus(856, ChronoUnit.DAYS)),
                new Car("modelB", "Nissan", 1.3, 2, 1, "white", LocalDate.now().minus(95, ChronoUnit.DAYS)),
                new Car("modelA", "BMW", 1.2, 233, 3, "white", LocalDate.now().minus(321, ChronoUnit.DAYS)),
                new Car("modelD", "Audi", 3.6, 1841, 2, "blue", LocalDate.now().minus(87, ChronoUnit.DAYS)),
                new Car("modelA", "Ford", 0.6, 87, 3, "brown", LocalDate.now().minus(56, ChronoUnit.DAYS)),
                new Car("modelD", "Fiat", 1.4, 19, 2, "pink", LocalDate.now().minus(65, ChronoUnit.DAYS)),
                new Car("modelD", "Volvo", 1.0, 4, 1, "green", LocalDate.now().minus(15, ChronoUnit.DAYS)),
                new Car("modelC", "GMC", 1.8, 345, 3, "grey", LocalDate.now().minus(987, ChronoUnit.DAYS)),
                new Car("modelC", "Mazda", 1.2, 3, 1, "red", LocalDate.now().minus(85, ChronoUnit.DAYS))
        );
    }

    private List<Customer> createCustomers() {
        return Arrays.asList(
                new Customer("Jack", 1),
                new Customer("Tom", 2),
                new Customer("Sam", 3)
        );
    }
}
