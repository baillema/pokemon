import me.sargunvohra.lib.pokekotlin.client.PokeApi;
import me.sargunvohra.lib.pokekotlin.client.PokeApiClient;
import me.sargunvohra.lib.pokekotlin.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Predicate;

public class InfoRetriever {
    private static int MAX_ITEMS = 100;
    private static int SPECIES_LIM = 10000;

    private static PokeApi API = new PokeApiClient();

    //----------------------------------------------------------------------------------------------------------------//
    //                                                  POKEMONS                                                      //
    //----------------------------------------------------------------------------------------------------------------//

    public static List<Integer> getPokemonsIds() {
        return getIds(API::getPokemonList, SPECIES_LIM);
    }

    public static List<PokemonSpecies> getPokemons(int lower, int upper) {
        List<PokemonSpecies> results = new ArrayList<>();

        for (int i = lower; i < upper; i++) {
            results.add(API.getPokemonSpecies(i));
        }

        return results;
    }

    public static List<PokemonSpecies> getPokemons() {
        return getPokemons(1, getSpeciesIds().size() + 1);
    }

    public static List<Integer> getSpeciesIds() {
        return getIds(API::getPokemonSpeciesList);
    }

    public static List<String> getSpeciesNames(String lang) {
        List<String> results = new ArrayList<>();

        int nbItems = getSpeciesIds().size();

        //for (int i = 1; i < nbItems + 1; i++) {
        for (int i = 501; i < 551; i++) {
            System.out.println("processing pokemon " + i);
            Optional<Name> name = API.getPokemonSpecies(i).getNames().stream().filter(filterName(lang)).findFirst();
            if (name.isPresent()) {
                results.add(name.get().getName());
            }
        }

        return results;
    }

    //----------------------------------------------------------------------------------------------------------------//
    //                                               CHARACTERISTICS                                                  //
    //----------------------------------------------------------------------------------------------------------------//

    public static List<Integer> getPokemonsGendersIds() {
        return getIds(API::getGenderList);
    }

    public static List<Integer> getPokemonsOfGender(int id) {
        List<Integer> ids = new ArrayList<>();
        API.getGender(id).getPokemonSpeciesDetails().stream().forEach(p -> ids.add(p.getPokemonSpecies().getId()));
        return ids;
    }

    public static List<String> getGendersEnglishNames() {
        return getNames(API::getGenderList);
    }

    public static List<Integer> getNaturesIds() {
        return getIds(API::getNatureList);
    }

    public static List<String> getNaturesNames(String lang) {
        List<String> results = new ArrayList<>();

        int nbItems = getNaturesIds().size();
        for (int i = 1; i < nbItems + 1; i++) {
            Optional<Name> name = API.getNature(i).getNames().stream().filter(filterName(lang)).findFirst();
            if (name.isPresent()) {
                results.add(name.get().getName());
            }
        }

        return results;
    }

    public static List<Integer> getColorsIds() {
        return getIds(API::getPokemonColorList);
    }

    public static List<String> getColorsNames(String lang) {
        List<String> results = new ArrayList<>();

        int nbItems = getColorsIds().size();
        for (int i = 1; i < nbItems + 1; i++) {
            Optional<Name> name = API.getPokemonColor(i).getNames().stream().filter(filterName(lang)).findFirst();
            if (name.isPresent()) {
                results.add(name.get().getName());
            }
        }

        return results;
    }

    public static List<Integer> getShapesIds() {
        return getIds(API::getPokemonShapeList);
    }

    public static List<String> getShapesNames(String lang) {
        List<String> results = new ArrayList<>();

        int nbItems = getShapesIds().size();
        for (int i = 1; i < nbItems + 1; i++) {
            Optional<Name> name = API.getPokemonShape(i).getNames().stream().filter(filterName(lang)).findFirst();
            if (name.isPresent()) {
                results.add(name.get().getName());
            }
        }

        return results;
    }

    public static List<Integer> getHabitatsIds() {
        return getIds(API::getPokemonHabitatList);
    }

    public static List<String> getHabitatsNames(String lang) {
        List<String> results = new ArrayList<>();

        int nbItems = getHabitatsIds().size();
        for (int i = 1; i < nbItems + 1; i++) {
            Optional<Name> name = API.getPokemonHabitat(i).getNames().stream().filter(filterName(lang)).findFirst();
            if (name.isPresent()) {
                results.add(name.get().getName());
            }
        }

        return results;
    }

    public static List<String> getDescriptionsTexts(List<PokemonSpecies> pokemons, String lang) {
        List<String> results = new ArrayList<>();

        for (PokemonSpecies p : pokemons) {
            List<PokemonSpeciesFlavorText> entries = p.getFlavorTextEntries();
            Optional<PokemonSpeciesFlavorText> flavor = entries.stream().filter(filterText(lang)).findFirst();
            if (flavor.isPresent()) {
                results.add(flavor.get().getFlavorText());
            }
        }

        return results;
    }

    //----------------------------------------------------------------------------------------------------------------//
    //                                                   ITEMS                                                        //
    //----------------------------------------------------------------------------------------------------------------//

    // TODO

    //----------------------------------------------------------------------------------------------------------------//
    //                                                   OTHERS                                                       //
    //----------------------------------------------------------------------------------------------------------------//

    public static List<String> getLanguagesNames() {
        return getNames(API::getLanguageList);
    }

    public static int getLanguageId(String lang) {
        List<NamedApiResource> languages = getObjects(API::getLanguageList);
        Optional<NamedApiResource> language = findFirstOfLang(languages, lang);
        return language.isPresent() ? language.get().getId() - 1 : -1;
    }

    //----------------------------------------------------------------------------------------------------------------//
    //                                                    UTILS                                                       //
    //----------------------------------------------------------------------------------------------------------------//

    private static Predicate<Name> filterName(String lang) {
        return name -> name.getLanguage().getName().equals(lang);
    }

    private static Predicate<PokemonSpeciesFlavorText> filterText(String lang) {
        return name -> name.getLanguage().getName().equals(lang);
    }

    private static Optional<NamedApiResource> findFirstOfLang(List<NamedApiResource> resources, String lang) {
        return resources.stream().filter(r -> r.getName().equals(lang)).findFirst();
    }

    private static List<NamedApiResource> getObjects(BiFunction<Integer, Integer, NamedApiResourceList> function) {
        List<NamedApiResource> results = new ArrayList<>();

        int offset = 0;
        NamedApiResourceList retrieved = function.apply(offset, MAX_ITEMS);
        retrieved.getResults().forEach(n -> results.add(n));


        while (retrieved.getNext() != null) {
            offset += MAX_ITEMS;
            retrieved = function.apply(offset, MAX_ITEMS);
            retrieved.getResults().forEach(n -> results.add(n));
        }

        return results;
    }

    private static List<String> getNames(BiFunction<Integer, Integer, NamedApiResourceList> function) {
        List<NamedApiResource> resources = getObjects(function);
        List<String> results = new ArrayList<>();
        resources.forEach(r -> results.add(r.getName()));
        return results;
    }

    private static List<Integer> getIds(BiFunction<Integer, Integer, NamedApiResourceList> function, int idLimit) {
        List<NamedApiResource> resources = getObjects(function);
        List<Integer> results = new ArrayList<>();
        resources.stream().filter(r -> r.getId() < idLimit).forEach(r -> results.add(r.getId()));
        return results;
    }

    private static List<Integer> getIds(BiFunction<Integer, Integer, NamedApiResourceList> function) {
        return getIds(function, Integer.MAX_VALUE);
    }
}
