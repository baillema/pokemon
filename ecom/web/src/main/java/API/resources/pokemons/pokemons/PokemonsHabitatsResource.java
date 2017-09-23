package API.resources.pokemons.pokemons;

import database.dao.pokemons.PokemonsHabitatsDao;
import database.entities.pokemons.PokemonsHabitatsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-habitats")
public class PokemonsHabitatsResource extends Application {
    @EJB
    private PokemonsHabitatsDao pokemonsHabitatsDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsHabitatsDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsHabitatsDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsHabitatsEntity habitat) {
        pokemonsHabitatsDao.create(habitat);

        return Response.status(Response.Status.CREATED)
                       .entity(habitat)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsHabitatsEntity habitat) {
        return put(habitat.getId(), habitat);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsHabitatsEntity habitat) {
        habitat.setId(id);
        pokemonsHabitatsDao.update(habitat);

        return Response.ok(habitat)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsHabitatsEntity habitat) {
        return delete(habitat.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsHabitatsDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
