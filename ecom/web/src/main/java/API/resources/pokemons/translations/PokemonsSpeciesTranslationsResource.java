package API.resources.pokemons.translations;

import database.consts.Requests;
import database.dao.IGenericDao;
import database.entities.pokemons.translations.PokemonsSpeciesTranslationsEntity;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/pokemons-species-translations")
public class PokemonsSpeciesTranslationsResource {
    @EJB
    private IGenericDao<PokemonsSpeciesTranslationsEntity> dao;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_ALL))
                       .build();
    }

    @GET
    @Path("/french")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllFrench() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_FR))
                       .build();
    }

    @GET
    @Path("/english")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllEnglish() {
        return Response.ok(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_EN))
                       .build();
    }

    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromId(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_FROM_ID, id))
                       .build();
    }

    @GET
    @Path("/lang/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromLang(@PathParam("id") int id) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_FROM_LANG, id))
                       .build();
    }

    @GET
    @Path("/idLang/{species-id}/{lang-id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLang(@PathParam("species-id") int id, @PathParam("lang-id") int lang) {
        return Response.status(Response.Status.OK)
                       .entity(dao.findWithNamedQuery(Requests.POK_SPEC_TRANS_FROM_ID_LANG, id, lang))
                       .build();
    }
}
