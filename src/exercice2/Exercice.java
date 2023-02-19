package exercice2;

import database.Connexion;
import models.Company;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/*
    Create a database connection to the PostgreSQL server.
    Create a Sql query for insert.
    INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (1, 'Paul', 32, 'California', 20000.00 );

    INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (2, 'Allen', 25, 'Texas', 15000.00 );

    INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (3, 'Teddy', 23, 'Norway', 20000.00 );

    INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)
    VALUES (4, 'Mark', 25, 'Rich-Mond ', 65000.00 );

    Execute the query to insert to the table
*/

public class Exercice2 {
    public static void insertCompany(List<Company> companies) {
        final String SQL = """
                    INSERT INTO company(id, name, age, address, salary)
                    VALUES(?, ?, ?, ?, ?)
                """;

        try {
            Connection connection = new Connexion().getConnecion();
            PreparedStatement statement = connection.prepareStatement(SQL);
            int count = 0;

            for (Company company : companies) {
                statement.setInt(1, company.getId());
                statement.setString(2, company.getName());
                statement.setInt(3, company.getAge());
                statement.setString(4, company.getAddress());
                statement.setDouble(5, company.getSalary());

                statement.addBatch();
                count++;
                if (count == companies.size()) {
                    statement.executeBatch();
                }
            }
            System.out.println("Données insérées avec succès");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
