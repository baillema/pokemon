package API.resources.pokemons;

import database.dao.pokemons.PokemonsSpeciesDao;
import database.entities.pokemons.PokemonsSpeciesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-species")
public class PokemonsSpeciesResource extends Application {
    @EJB
    private PokemonsSpeciesDao pokemonsSpeciesDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsSpeciesDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsSpeciesDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsSpeciesEntity pokemonSpecies) {
        pokemonsSpeciesDao.create(pokemonSpecies);

        return Response.status(Response.Status.CREATED)
                       .entity(pokemonSpecies)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsSpeciesEntity pokemonSpecies) {
        return put(pokemonSpecies.getId(), pokemonSpecies);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsSpeciesEntity pokemonSpecies) {
        pokemonSpecies.setId(id);
        pokemonsSpeciesDao.update(pokemonSpecies);

        return Response.ok(pokemonSpecies)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsSpeciesEntity pokemonSpecies) {
        return delete(pokemonSpecies.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsSpeciesDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
