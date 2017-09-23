package API.resources.pokemons.pokemons;

import database.dao.pokemons.PokemonsDescriptionsDao;
import database.entities.pokemons.PokemonsDescriptionsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-descriptions")
public class PokemonsDescriptionsResource extends Application {
    @EJB
    private PokemonsDescriptionsDao pokemonsDescriptionsDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsDescriptionsDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsDescriptionsDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsDescriptionsEntity description) {
        pokemonsDescriptionsDao.create(description);

        return Response.status(Response.Status.CREATED)
                       .entity(description)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsDescriptionsEntity description) {
        return put(description.getId(), description);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsDescriptionsEntity description) {
        description.setId(id);
        pokemonsDescriptionsDao.update(description);

        return Response.ok(description)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsDescriptionsEntity description) {
        return delete(description.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsDescriptionsDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
