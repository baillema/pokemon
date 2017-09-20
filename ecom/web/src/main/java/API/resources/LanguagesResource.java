package API.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("languages")
public class LanguagesResource extends Application {
    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllLanguages() {
        return Response.status(Response.Status.OK)
                       .entity(em.createQuery("SELECT l FROM LanguagesEntity l")
                                 .getResultList())
                       .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getLanguageById(@PathParam("id") String id) {
        return Response.status(Response.Status.OK)
                       .entity(em.createQuery("SELECT l FROM LanguagesEntity l WHERE l.id = :language_id")
                                 .setParameter("language_id", id)
                                 .getResultList())
                       .build();
    }
}
