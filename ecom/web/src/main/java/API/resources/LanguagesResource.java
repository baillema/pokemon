package API.resources;


import com.sun.org.apache.regexp.internal.RE;
import database.dao.LanguagesDao;
import database.entities.LanguagesEntity;

import javax.ejb.EJB;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/languages")
public class LanguagesResource extends Application {
    @EJB
    private LanguagesDao languagesDao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(languagesDao.readAll())
                       .build();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(languagesDao.read(id))
                       .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response post(LanguagesEntity language) {
        languagesDao.create(language);

        return Response.status(Response.Status.CREATED)
                       .entity(language)
                       .build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(LanguagesEntity language) {
        return put(language.getId(), language);
    }

    @PUT
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response put(@PathParam("id") int id, LanguagesEntity language) {
        language.setId(id);
        languagesDao.update(language);

        return Response.ok(language)
                       .build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(LanguagesEntity language) {
        return delete(language.getId());
    }

    @DELETE
    @Path("/{id}")
    public Response delete(@PathParam("id") int id) {
        languagesDao.delete(id);

        return Response.noContent()
                       .build();
    }
}
