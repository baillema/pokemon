package API;

import API.resources.LanguagesResource;
import API.resources.PokemonSpeciesResource;
import API.resources.SearchFromElastic;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class Api extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(PokemonSpeciesResource.class);
        classes.add(LanguagesResource.class);
        classes.add(SearchFromElastic.class);
        return classes;
    }
}
