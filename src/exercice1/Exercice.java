package exercice1;

import database.Connexion;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/*
    Create a database connection to the PostgreSQL server.
    Create a SQL query.
    Execute a query to create the table
*/
public class Exercice1 {
    public static void createTable() {
        final String SQL = """
                    CREATE TABLE company(
                        id SERIAL PRIMARY KEY NOT NULL,
                        name TEXT NOT NULL,
                        age INT NOT NULL,
                        address CHAR(50),
                        salary REAL
                    )
                """;

        try {
            Connection connection = new Connexion().getConnecion();
            Statement statement = connection.createStatement();

            statement.executeUpdate(SQL);
            System.out.println("Table créé avec succès");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
