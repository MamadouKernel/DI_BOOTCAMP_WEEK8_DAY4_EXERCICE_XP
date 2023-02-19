import database.Connexion;
import exercice1.Exercice1;
import exercice2.Exercice2;
import exercice3.Exercice3;
import models.Company;

import java.sql.Connection;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //Exercice 1
        Exercice1.createTable();

        //Exercice 2
        List<Company> companies = Arrays.asList(
                new Company(1, "Paul", 32, "California", 20000.00),
                new Company(2, "Allen", 25, "Texas", 15000.00),
                new Company(3, "Teddy", 23, "Norway", 20000.00),
                new Company(4, "Mark", 25, "Rich-Mond ", 65000.00)
        );
        Exercice2.insertCompany(companies);

        //Exercice 3
        List<Company> companiesFromBD = Exercice3.getALlCompany();
        System.out.println("======== LISTE DES ENTREPRISES ==========");
        companiesFromBD.forEach(System.out::println);
    }
}
