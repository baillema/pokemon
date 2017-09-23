package API.resources;

import database.consts.Requests;
import database.dao.IGenericDao;
import database.entities.LanguagesEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/languages")
public class LanguagesResource extends Application {
    @EJB
    private IGenericDao<LanguagesEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.LANGUAGES_ALL))
                       .build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.LANGUAGES_FROM_ID, id))
                       .build();
    }
    @GET
    @Path("/name/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("name") String name) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.LANGUAGES_FROM_LANG, name))
                       .build();
    }
}
