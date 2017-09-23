package API.resources.pokemons.pokemons;

import database.dao.pokemons.PokemonsGendersDao;
import database.entities.pokemons.PokemonsGendersEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class PokemonsGendersResource {
    @EJB
    private PokemonsGendersDao pokemonsGendersDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(pokemonsGendersDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(pokemonsGendersDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsGendersEntity gender) {
        pokemonsGendersDao.create(gender);

        return Response.status(Response.Status.CREATED)
                       .entity(gender)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(PokemonsGendersEntity gender) {
        return put(gender.getId(), gender);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, PokemonsGendersEntity gender) {
        gender.setId(id);
        pokemonsGendersDao.update(gender);

        return Response.ok(gender)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(PokemonsGendersEntity gender) {
        return delete(gender.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        pokemonsGendersDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
