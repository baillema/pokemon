package API.resources.pokemons;

import database.consts.Requests;
import database.dao.IGenericDao;
import database.entities.pokemons.PokemonsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons")
public class PokemonsResource extends Application{
    @EJB
    private IGenericDao<PokemonsEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_ALL))
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_FROM_ID, id))
                       .build();
    }
}
