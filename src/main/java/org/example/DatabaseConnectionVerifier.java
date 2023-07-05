package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DatabaseConnectionVerifier {


    public static void main(String[] args) {
        try {
            // Load the MySQL JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            // Database connection parameters
            String url = "jdbc:mysql://localhost:3306/Saleh_welate";
            String username = "root";
            String password = "Kholio@4646";

            // Attempt to establish a connection
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                System.out.println("Database connection successful!");
            } catch (SQLException e) {
                System.err.println("Database connection failed!");
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC driver not found!");
            e.printStackTrace();
        }
    }





/*
    public static boolean isDatabaseConnected() {
        // Nom de l'unité de persistance à utiliser (doit correspondre à celui défini dans persistence.xml)
        String persistenceUnitName = "MyPersistenceUnit";

        // Créer l'EntityManagerFactory avec l'unité de persistance définie dans persistence.xml
        EntityManagerFactory emf = null;
        try {
            emf = Persistence.createEntityManagerFactory(persistenceUnitName);
            return true; // La connexion a réussi
        } catch (Exception e) {
            e.printStackTrace();
            return false; // La connexion a échoué
        } finally {
            // Fermer l'EntityManagerFactory pour libérer les ressources
            if (emf != null) {
                emf.close();
            }
        }
    }

    public static void main(String[] args) {
        if (isDatabaseConnected()) {
            System.out.println("La connexion à la base de données a réussi !");
        } else {
            System.out.println("Impossible de se connecter à la base de données.");
        }
    }*/
}

