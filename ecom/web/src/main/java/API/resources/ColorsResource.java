package API.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("colors")
public class ColorsResource extends Application {
    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllColors() {
        return Response.status(Response.Status.OK)
                       .entity(em.createQuery("SELECT c FROM PokemonsColorsEntity c")
                                 .getResultList())
                       .build();
    }
}
