package API;

import API.resources.LanguagesResource;
import API.resources.SearchFromElastic;
import API.resources.pokemons.pokemons.PokemonsColorsResource;
import API.resources.pokemons.pokemons.PokemonsSpeciesResource;
import API.resources.pokemons.pokemons.PokemonsSpeciesTranslationsResource;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("api")
public class Api extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        classes.add(LanguagesResource.class);
        classes.add(PokemonsColorsResource.class);
        classes.add(PokemonsSpeciesResource.class);
        classes.add(PokemonsSpeciesTranslationsResource.class);
        classes.add(SearchFromElastic.class);
        return classes;
    }
}
