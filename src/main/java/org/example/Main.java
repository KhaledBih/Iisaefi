package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import io.undertow.Undertow;
import org.example.model.MedicalRecord;
import org.example.model.UserModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.example.ressource.UserResource;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;
import org.jboss.resteasy.spi.ResteasyDeployment;


import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;
import java.io.File;



import org.example.model.UserModel;
import org.example.model.UserModel.UserRole;
import org.example.service.UserService;

import javax.ejb.EJB;

import javax.inject.Inject;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    @Inject // Use @Inject for CDI-based injection
    private static UserService userService;


        public static void main(String[] args) throws Exception {
            Configuration config = new Configuration();
            config.configure(
                    "src/resources/hibernate.cfg.xml");
            SessionFactory sessionFactory = config.buildSessionFactory();
        userService= new UserService();
        // Create a new user
        UserModel user1 = new UserModel();
        user1.setId("1");
        user1.setEmail("user1@example.com");
        user1.setPassword("password123");
        user1.setFullName("John Doe");
        user1.setPhoneNumber("1234567890");
        user1.setRole(UserRole.USER);
        userService.createUser(user1);

        // Get a user by their ID
        UserModel retrievedUser = userService.getUserById("1");
        System.out.println("Retrieved User: " + retrievedUser.toJson());

        // Update the user's full name
        retrievedUser.setFullName("Jane Doe");
        userService.updateUser(retrievedUser);

        // Get the updated user by their ID
        UserModel updatedUser = userService.getUserById("1");
        System.out.println("Updated User: " + updatedUser.toJson());

        // Delete the user by their ID
        userService.deleteUser("1");

        // Attempt to retrieve the user after deletion (should return null)
        UserModel deletedUser = userService.getUserById("1");
        if (deletedUser == null) {
            System.out.println("User with ID '1' is deleted.");
        }

            // Fermez la sessionFactory lorsque vous avez terminé
            sessionFactory.close();
    }
}




/*public class Main {
    public static void main(String[] args) throws Exception {

        // Create the EntityManagerFactory with the persistence unit name defined in persistence.xml
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("MyPersistenceUnit");

        // Create the EntityManager
        EntityManager em = emf.createEntityManager();

        // Create some sample user data
        UserModel user1 = new UserModel();
        user1.setId("1");
        user1.setEmail("user1@example.com");
        user1.setPassword("password123");
        user1.setFullName("User One");
        user1.setPhoneNumber("1234567890");
        user1.setRole(UserModel.UserRole.USER);
        // ... Set other fields

        UserModel user2 = new UserModel();
        user2.setId("2");
        user2.setEmail("user2@example.com");
        user2.setPassword("password456");
        user2.setFullName("User Two");
        user2.setPhoneNumber("9876543210");
        user2.setRole(UserModel.UserRole.DOCTOR);
        // ... Set other fields

        // Create some sample medical record data
        MedicalRecord record1 = new MedicalRecord();
        record1.setId("1");
        record1.setPatientName("Patient One");
        // ... Set other fields

        MedicalRecord record2 = new MedicalRecord();
        record2.setId("2");
        record2.setPatientName("Patient Two");
        // ... Set other fields

        // Perform database operations using JPA
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        // Persist the entities to the database
        em.persist(user1);
        em.persist(user2);
        em.persist(record1);
        em.persist(record2);

        // Commit the transaction
        transaction.commit();

        // Fetch data from the database using JPA
        UserModel fetchedUser = em.find(UserModel.class, "1");
        MedicalRecord fetchedRecord = em.find(MedicalRecord.class, "1");

        // Print the fetched data
        System.out.println("Fetched User: " + fetchedUser);
        System.out.println("Fetched Medical Record: " + fetchedRecord);

        // Close the EntityManager and EntityManagerFactory
        em.close();
        emf.close();

    }
}*/
    /*
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8080);

        String contextPath = "/";
        String docBase = new File(".").getAbsolutePath();

        Context context = tomcat.addContext(contextPath, docBase);

        // Ajoutez le servlet RestEasy
        Tomcat.addServlet(context, "ResteasyServlet", new HttpServletDispatcher());
        context.addServletMappingDecoded("/api/*", "ResteasyServlet");

        // Déployer la ressource utilisateur
        context.addApplicationListener(UserResource.class.getName());

        tomcat.start();
        tomcat.getServer().await();
*/