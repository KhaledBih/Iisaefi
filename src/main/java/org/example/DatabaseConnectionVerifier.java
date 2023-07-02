package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DatabaseConnectionVerifier {

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
    }
}

