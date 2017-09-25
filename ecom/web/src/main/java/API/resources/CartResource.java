package API.resources;

import database.dao.CartDao;
import database.entities.CartsEntity;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Set;

@Path("cart")
public class CartResource extends Application {

    @EJB
    private CartDao cartDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CartsEntity getCurrentCart() {
        return cartDao.findCurrentCart(1);
    }

    @Path("history")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getShoppingHistory() {
        return cartDao.findAllByBoughtCart(1);
    }
}
