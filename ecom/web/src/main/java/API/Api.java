package API;

import API.resources.LanguagesResource;
import API.resources.SearchFromElastic;
import API.resources.articles.PokemonsArticlesResource;
import API.resources.pokemons.PokemonsResource;
import API.resources.pokemons.base.*;
import API.resources.pokemons.translations.*;
import API.resources.CartResource;
import API.resources.PokemonResource;
import API.resources.UserResource;
import database.entities.articles.PokemonsArticlesEntity;


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
        classes.add(PokemonsArticlesResource.class);
        classes.add(PokemonsResource.class);
        classes.add(PokemonsColorsResource.class);
        classes.add(PokemonsDescriptionsResource.class);
        classes.add(PokemonsGendersResource.class);
        classes.add(PokemonsHabitatsResource.class);
        classes.add(PokemonsShapesResource.class);
        classes.add(PokemonsSpeciesResource.class);
        classes.add(PokemonsColorsTranslationsResource.class);
        classes.add(PokemonsDescriptionsTranslationsResource.class);
        classes.add(PokemonsGendersTranslationsResource.class);
        classes.add(PokemonsHabitatsTranslationsResource.class);
        classes.add(PokemonsShapesTranslationsResource.class);
        classes.add(PokemonsSpeciesTranslationsResource.class);
        classes.add(SearchFromElastic.class);
        classes.add(UserResource.class);
        classes.add(CartResource.class);
        classes.add(PokemonResource.class);
        return classes;
    }
}
