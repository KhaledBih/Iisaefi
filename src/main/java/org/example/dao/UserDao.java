package org.example.dao;

import org.example.model.UserModel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

@Stateless
public class UserDao {
    // Utilisez la SessionFactory pour obtenir l'EntityManager
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("MyPersistenceUnit");

    // Obtenez l'EntityManager à partir de la SessionFactory
    private EntityManager entityManager = entityManagerFactory.createEntityManager();

    // Create a new user
    public void createUser(UserModel user) {
        entityManager.persist(user);
    }

    // Retrieve a user by their ID
    public UserModel getUserById(String id) {
        return entityManager.find(UserModel.class, id);
    }

    // Update a user
    public void updateUser(UserModel user) {
        entityManager.merge(user);
    }

    // Delete a user by their ID
    public void deleteUser(String id) {
        UserModel user = entityManager.find(UserModel.class, id);
        if (user != null) {
            entityManager.remove(user);
        }
    }

    // Fermez l'EntityManager lorsque vous avez terminé avec cette instance de UserDao
    public void closeEntityManager() {
        if (entityManager != null && entityManager.isOpen()) {
            entityManager.close();
        }
    }
}
