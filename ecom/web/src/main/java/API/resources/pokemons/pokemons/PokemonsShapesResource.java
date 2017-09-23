package API.resources.pokemons.pokemons;

import database.dao.pokemons.PokemonsShapesDao;
import database.entities.pokemons.PokemonsShapesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-shapes")
public class PokemonsShapesResource extends Application {
    @EJB
    private PokemonsShapesDao pokemonsShapesDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsShapesDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsShapesDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsShapesEntity shape) {
        pokemonsShapesDao.create(shape);

        return Response.status(Response.Status.CREATED)
                       .entity(shape)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsShapesEntity shape) {
        return put(shape.getId(), shape);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsShapesEntity shape) {
        shape.setId(id);
        pokemonsShapesDao.update(shape);

        return Response.ok(shape)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsShapesEntity shape) {
        return delete(shape.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsShapesDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
