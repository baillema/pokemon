package API.resources.pokemons.translations;

import database.consts.Requests;
import database.dao.IGenericDao;
import database.entities.pokemons.base.PokemonsGendersEntity;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-genders-translations")
public class PokemonsGendersTranslationsResource extends Application {
    @EJB
    private IGenericDao<PokemonsGendersEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_ALL))
                       .build();
    }

    @GET
    @Path("/french")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFrench() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_FR))
                       .build();
    }

    @GET
    @Path("/english")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnglish() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_EN))
                       .build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromId(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_FROM_ID, id))
                       .build();
    }

    @GET
    @Path("/lang/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromLang(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_FROM_LANG, id))
                       .build();
    }

    @GET
    @Path("/idLang/{species-id}/{lang-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLang(@PathParam("species-id") int id, @PathParam("lang-id") int lang) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_GEND_TRANS_FROM_ID_LANG, id, lang))
                       .build();
    }
}
