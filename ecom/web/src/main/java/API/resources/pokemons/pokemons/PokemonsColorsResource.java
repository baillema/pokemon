package API.resources.pokemons.pokemons;

import database.dao.pokemons.PokemonsColorsDao;
import database.entities.pokemons.PokemonsColorsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-colors")
public class PokemonsColorsResource extends Application {
    @EJB
    private PokemonsColorsDao pokemonsColorsDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsColorsDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsColorsDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsColorsEntity pokemonColor) {
        pokemonsColorsDao.create(pokemonColor);

        return Response.status(Response.Status.CREATED)
                       .entity(pokemonColor)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsColorsEntity pokemonColor) {
        return put(pokemonColor.getId(), pokemonColor);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsColorsEntity pokemonColor) {
        pokemonColor.setId(id);
        pokemonsColorsDao.update(pokemonColor);

        return Response.ok(pokemonColor)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsColorsEntity pokemonColor) {
        return delete(pokemonColor.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsColorsDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
