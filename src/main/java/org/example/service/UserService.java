
package org.example.service;

import org.example.dao.UserDao;
import org.example.model.UserModel;

import javax.ejb.EJB;

public class UserService {
    @EJB
    private UserDao userDAO= new UserDao();

    // Create a new user
    public void createUser(UserModel user) {
        userDAO.createUser(user);
    }

    // Get a user by their ID
    public UserModel getUserById(String id) {
        return userDAO.getUserById(id);
    }

    // Update a user
    public void updateUser(UserModel user) {
        userDAO.updateUser(user);
    }

    // Delete a user by their ID
    public void deleteUser(String id) {
        userDAO.deleteUser(id);
    }
}




//package org.example.service;

/*

import javax.inject.Inject;

import java.util.*;
import org.example.model.UserModel;

public class UserService {

    private final UserDao userDao;

    @Inject
    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserModel addUser(UserModel user) {
        // Logique pour ajouter un utilisateur dans la base de données
        // Utilisez userDao pour interagir avec la base de données
        // Renvoie l'utilisateur créé avec l'ID généré par la base de données
    }

    public UserModel getUserById(String userId) {
        // Logique pour récupérer un utilisateur par son ID
    }

    public List<UserModel> getAllUsers() {
        // Logique pour récupérer tous les utilisateurs de la base de données
    }

    public UserModel updateUser(UserModel user) {
        // Logique pour mettre à jour un utilisateur dans la base de données
    }

    public void deleteUser(String userId) {
        // Logique pour supprimer un utilisateur de la base de données par son ID
    }
}
*/
