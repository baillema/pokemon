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
        return null;
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
        Query query = em.createQuery("SELECT pokemonSpecies " +
                                        "FROM PokemonsSpeciesTranslationsEntity pokemonSpecies " +
                                        "JOIN LanguagesEntity languages " +
                                        "WHERE pokemonSpecies.languageId = :language")
                        .setParameter("language", 1);

        return Response.status(Response.Status.OK).entity(query.getResultList()).build();
    }
}
