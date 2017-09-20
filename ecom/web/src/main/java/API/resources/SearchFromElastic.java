package API.resources;

import elasticsearch.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "pokelastic")
public class SearchFromElastic extends javax.ws.rs.core.Application {

    Search elasticSearch = new Search();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/matchall/{indices}")
    public String getMatchAll(@PathParam("indices") String indices) {
        return elasticSearch.matchAll(indices);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/simple/{indices}/{name}/{wordsearched}")
    public String getSimpleSearch(@PathParam("indices") String indices, @PathParam("name") String name, @PathParam("wordsearched") String wordsearched) {
        return elasticSearch.simpleSearch(indices, name, wordsearched);
    }

    /*
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/multi/{indices}/{name}/{wordsearched}/{typeRequest}/{facetName}/{facetValue}/{nbFacet}")
    public String getMultisearch(@PathParam("indices") String indices, @PathParam("name") String name,  @PathParam("wordsearched") String wordsearched, @PathParam("typeRequest") int typeRequest, @PathParam("facetName") String facetName[], @PathParam("facetValue") String facetValue[], @PathParam("nbFacet") int nbFacets) {
        return elasticSearch.multiSearch(indices,name,wordsearched,typeRequest,facetName,facetValue,nbFacets);
    }*/

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/exact/{indices}/{name}/{wordsearched}")
    public String getExactSearch(@PathParam("indices") String indices, @PathParam("name") String name, @PathParam("wordsearched") String wordsearched) {
        return elasticSearch.exactSearch(indices, name, wordsearched);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/wildcard/{indices}/{name}/{wordsearched}")
    public String getWildcardSearch(@PathParam("indices") String indices, @PathParam("name") String name, @PathParam("wordsearched") String wordsearched) {
        return elasticSearch.wildcardSearch(indices, name, wordsearched);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/fuzzy/{indices}/{name}/{wordsearched}")
    public String getFuzzySearch(@PathParam("indices") String indices, @PathParam("name") String name, @PathParam("wordsearched") String wordsearched) {
        return elasticSearch.fuzzySearch(indices, name, wordsearched);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/auto/{indices}/{name}/{wordsearched}")
    public String getAutocomplete(@PathParam("indices") String indices, @PathParam("name") String name, @PathParam("wordsearched") String wordsearched) {
        return elasticSearch.autocomplete(indices, name, wordsearched);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/stopword/{wordsearched}/{language}")
    public String getStopWord(@PathParam("wordsearched") String wordsearched, @PathParam("language") String language) {
        return elasticSearch.stopword(wordsearched, language);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/auto/{wordsearched}/{language}")
    public String getLemmatisation(@PathParam("wordsearched") String wordsearched, @PathParam("language") String language) {
        return elasticSearch.lemmatisation(wordsearched, language);
    }



}
