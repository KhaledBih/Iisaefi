package org.example.ressource;


import org.example.model.UserModel;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import java.util.ArrayList;
import java.util.Date;


@Path("/users")
public class UserResource {

    // Liste statique de 5 utilisateurs pour les besoins de l'exemple
    private static List<UserModel> users = new ArrayList<>();

    static {
        users.add(new UserModel("1", "john@example.com", "password1", "John Doe", "1234567890", UserModel.UserRole.USER, "token1", new Date(), new Date(), null));
        users.add(new UserModel("2", "jane@example.com", "password2", "Jane Smith", "9876543210", UserModel.UserRole.DOCTOR, "token2", new Date(), new Date(), null));
        users.add(new UserModel("3", "bob@example.com", "password3", "Bob Johnson", "5555555555", UserModel.UserRole.OPERATOR, "token3", new Date(), new Date(), null));
        users.add(new UserModel("4", "alice@example.com", "password4", "Alice Brown", "1111111111", UserModel.UserRole.NURSE, "token4", new Date(), new Date(), null));
        users.add(new UserModel("5", "admin@example.com", "password5", "Admin User", "9999999999", UserModel.UserRole.ADMIN, "token5", new Date(), new Date(), null));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUsers() {
        return Response.ok(users).build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUserById(@PathParam("id") String id) {
        UserModel user = getUserByIdFromList(id);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUser(UserModel user) {
        // Générez un nouvel ID pour le nouvel utilisateur (à adapter selon votre cas)
        String newId = String.valueOf(users.size() + 1);
        user.setId(newId);

        users.add(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("id") String id, UserModel user) {
        UserModel existingUser = getUserByIdFromList(id);
        if (existingUser != null) {
            // Mettez à jour les attributs de l'utilisateur existant
            existingUser.setEmail(user.getEmail());
            existingUser.setFullName(user.getFullName());
            existingUser.setPassword(user.getPassword());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setRole(user.getRole());
            // ...

            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUser(@PathParam("id") String id) {
        UserModel user = getUserByIdFromList(id);
        if (user != null) {
            users.remove(user);
            return Response.noContent().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    // Méthode utilitaire pour obtenir un utilisateur par son ID à partir de la liste
    private UserModel getUserByIdFromList(String id) {
        for (UserModel user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }
}





























/*package org.example.ressource;




import org.example.model.UserModel;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    private UserDao userDao;

    @GET
    public List<UserModel> getAllUsers() {
        return userDao.getAllUsers();
    }

    @GET
    @Path("/{id}")
    public Response getUserById(@PathParam("id") String id) {
        User user = userDao.getUserById(id);
        if (user != null) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addUser(User user) {
        userDao.addUser(user);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateUser(@PathParam("id") String id, User updatedUser) {
        User existingUser = userDao.getUserById(id);
        if (existingUser != null) {
            // Update the existing user properties
            existingUser.setFullName(updatedUser.getFullName());
            existingUser.setEmail(updatedUser.getEmail());
            // ...
            userDao.updateUser(existingUser);
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deleteUserById(@PathParam("id") String id) {
        userDao.deleteUserById(id);
        return Response.ok().build();
    }
}
*/

