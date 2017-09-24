package API.resources.articles;

import database.consts.Requests;
import database.dao.GenericDao;
import database.dao.IGenericDao;
import database.entities.articles.PokemonsArticlesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-articles")
public class PokemonsArticlesResource extends Application {
    @EJB
    private IGenericDao<PokemonsArticlesEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_ART_ALL))
                       .build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_ART_FROM_ID, id))
                       .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(PokemonsArticlesEntity article) {
        System.out.println(article.getDescription());
        dao.create(article);
        return Response.status(Response.Status.CREATED).build();
    }
}
