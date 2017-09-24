package API.resources.pokemons.base;

import database.consts.Requests;
import database.dao.IGenericDao;
import database.entities.pokemons.base.PokemonsShapesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-shapes")
public class PokemonsShapesResource extends Application {
    @EJB
    private IGenericDao<PokemonsShapesEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_SHAP_ALL))
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_SHAP_FROM_ID, id))
                       .build();
    }
}
