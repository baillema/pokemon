package API.resources.pokemons;

import database.dao.pokemons.PokemonSpeciesTranslationsDao;
import database.entities.pokemons.PokemonsSpeciesTranslationsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-species-translations")
public class PokemonsSpeciesTranslationsResource {
    @EJB
    private PokemonSpeciesTranslationsDao pokemonSpeciesTranslationsDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonSpeciesTranslationsDao.readAll())
                       .build();
    }

    @GET
    @Path("/{species-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("species-id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonSpeciesTranslationsDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsSpeciesTranslationsEntity pokemonSpeciesTranslation) {
        pokemonSpeciesTranslationsDao.create(pokemonSpeciesTranslation);

        return Response.status(Response.Status.CREATED)
                       .entity(pokemonSpeciesTranslation)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsSpeciesTranslationsEntity pokemonSpeciesTranslation) {
        return put(pokemonSpeciesTranslation.getPokemonSpecieId(), pokemonSpeciesTranslation);
    }

    @PUT
    @Path("/{species-id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("species-id") int id, PokemonsSpeciesTranslationsEntity pokemonSpeciesTranslation) {
        pokemonSpeciesTranslation.setPokemonSpecieId(id);
        pokemonSpeciesTranslationsDao.update(pokemonSpeciesTranslation);

        return Response.ok(pokemonSpeciesTranslation)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsSpeciesTranslationsEntity pokemonSpeciesTranslation) {
        return delete(pokemonSpeciesTranslation.getPokemonSpecieId());
    }

    @DELETE
    @Path("/{species-id}")
    public Response delete(@PathParam("species-id") int id) {
        pokemonSpeciesTranslationsDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
