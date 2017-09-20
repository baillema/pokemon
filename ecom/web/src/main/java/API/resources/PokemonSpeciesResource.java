package API.resources;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/pokemon-species")
public class PokemonSpeciesResource extends Application {
    @PersistenceContext
    private EntityManager em;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPokemonSpecies() {
        return Response.status(Response.Status.OK).entity(em.createQuery("SELECT p FROM PokemonsSpeciesEntity p").getResultList()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getPokemonSpeciesOfLanguage(@PathParam("id") int languageId) {
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/french")
    public Response getPokemonSpeciesFrench() {
        Query query = em.createQuery("SELECT p " +
                                        "FROM PokemonsSpeciesTranslationsEntity p " +
                                        "JOIN p.languagesByLanguageId " +
                                        "WHERE p.languageId = 4");

        return Response.status(Response.Status.OK).entity(query.getResultList()).build();
    }
}
