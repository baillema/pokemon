package API.resources;

import elasticsearch.Search;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "pokelastic")
public class SearchFromElastic extends javax.ws.rs.core.Application {

    Search elasticSearch = new Search();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll() {
        return elasticSearch.matchAll("pokemons");
    }
}
