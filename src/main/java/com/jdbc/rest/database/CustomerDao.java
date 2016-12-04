package com.jdbc.rest.database;

import com.jdbc.rest.domain.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * Created by stas on 04.12.16.
 */
public class CustomerDao extends  EntityDao {

    public void createAndFillCustomersTable() {
        if (!isDatabaseInitialized) {

            Connection connection = new DataSource().getConnection();

            try {
                Statement statement = connection.createStatement();

                String dropCustomersTableSqlRequest = "DROP TABLE IF EXISTS CUSTOMERS";
                statement.executeUpdate(dropCustomersTableSqlRequest);

                String createCustomersTableSqlRequest = "CREATE TABLE CUSTOMERS (" +
                        "id INTEGER PRIMARY KEY AUTO_INCREMENT, " +
                        "name VARCHAR (15) NOT NULL)";
                statement.executeUpdate(createCustomersTableSqlRequest);

                addCustomersToDatabase(connection);

                statement.close();
                connection.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
            isDatabaseInitialized = true;
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
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    private List<Customer> createCustomers() {
        return Arrays.asList(
                new Customer("Jack", 1),
                new Customer("Tom", 2),
                new Customer("Sam", 3)
        );
    }
}
