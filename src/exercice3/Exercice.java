package exercice3;
/*
    In this exercise you will fetch and display records from our COMPANY table from the previous exercise using PostgreSQL JDBC
    Create a database connection to the PostgreSQL server.
    Create a Statement object.
    Execute a statement to fetch data

    SELECT * FROM COMPANY;
*/

import database.Connexion;
import models.Company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Exercice3 {
    public static List<Company> getALlCompany() {
        List<Company> companies = new ArrayList<>();
        final String SQL = "SELECT * FROM company";

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Company company = new Company(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getInt("age"),
                        resultSet.getString("address"),
                        resultSet.getDouble("salary")
                );
                companies.add(company);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return companies;
    }
}
