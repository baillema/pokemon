package API.resources;

import API.resources.beans.UserInputSignup;
import API.resources.beans.UserLog;
import Services.UserService;
import database.dao.CartDao;
import database.dao.UserDao;
import database.dao.UserRoleDao;
import database.entities.CartsEntity;
import database.entities.UsersEntity;
import database.entities.UsersRolesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("user")
public class UserResource extends Application {

    @EJB
    private UserDao userDao;
    @EJB
    private CartDao cartDao;
    @EJB
    private UserRoleDao userRoleDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getUsers() {
        return userDao.findAll();
    }

    @Path("signup")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public void createUserAccount(UserInputSignup input) {
        /*Check the same password*/
        if (UserService.samePassword(input.password, input.password_verify)) {
            //Create a user account
            UsersEntity newUser = new UsersEntity(
                    input.handle,
                    input.firstname,
                    input.gender,
                    input.email,
                    input.lastname,
                    input.password);

            //Create a cart assign to the user
            int newUserId = userDao.createAccount(newUser);
            cartDao.create(new CartsEntity(newUserId));

            //Create default roles
            //Trader
            userRoleDao.create(new UsersRolesEntity(newUserId, 4));
            //Buyer
            userRoleDao.create(new UsersRolesEntity(newUserId, 3));
        }
    }

    @Path("login")
    @POST
    @Consumes("application/json")
    @Produces(MediaType.APPLICATION_JSON)
    public UsersEntity login(final UserLog input) {
        return userDao.findByEmailAndPassword(input.email, input.password);
    }


    @Path("account/{handle}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public UsersEntity displayUserAccount(@PathParam("handle") String handle) {
        return userDao.findAccountByHandle(handle);
    }
}
