package API.resources;

import database.dao.CartDao;
import database.entities.CartsEntity;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("shopping")
public class CartResource extends Application {

    @EJB
    private CartDao cartDao;

    @Path("cart")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CartsEntity getCurrentCart() {
        return cartDao.findCurrentCart(1);
    }

    @Path("history")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Set<CartsEntity> getShoppingHistory() {
        return (Set<CartsEntity>) cartDao.findAllByBoughtCart(1);
    }
}
