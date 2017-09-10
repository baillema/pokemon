import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;
import me.sargunvohra.lib.pokekotlin.model.PokemonSpeciesFlavorText;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

public class Main {

    private static List<String> languagesToDo = Arrays.asList("fr", "en");

    public static void main(String[] args) {
        writePokemonSpeciesTransInserts(501);
    }

    public static void writeLanguagesInserts() {
        try {
            Files.deleteIfExists(Paths.get(Consts.LANGUAGE_FILE));
        } catch (IOException e) {
            e.printStackTrace();
        }

        SQLWriter.writeEnumTableInserts(Consts.LANGUAGE_FILE, Consts.LANGUAGE_TABLE, InfoRetriever.getLanguagesNames());
    }

    public static void writePokemonsInserts() {
        writeIdTable(Consts.POKEMONS_FILE, Consts.POKEMONS_TABLE, InfoRetriever::getPokemonsIds);
    }

    public static void writePokemonsGendersInserts() {
        writeIdTable(Consts.POKEMONS_GENDERS_FILE, Consts.POKEMONS_GENDERS_TABLE, InfoRetriever::getPokemonsGendersIds);
    }

    public static void writePokemonsGendersTransInserts() {
        Supplier<List<String>> supplier = InfoRetriever::getGendersEnglishNames;
        writeTranslateEn(Consts.POKEMONS_GENDERS_TRANS_FILE, Consts.POKEMONS_GENDERS_TRANS_TABLE, supplier);
    }

    public static void writePokemonsGendersCorrespondance() {
        for (int i = 0; i < 3; i++) {
            int id = i + 1;
            SQLWriter.writeCorrespondanceTable(Consts.POKEMONS_ACCEPTED_GENDERS_FILE, Consts
                    .POKEMONS_ACCEPTED_GENDERS_TABLE, id, InfoRetriever.getPokemonsOfGender(id));
        }
    }

    public static void writePokemonsSpeciesInserts() {
        writeIdTable(Consts.POKEMONS_SPECIES_FILE, Consts.POKEMONS_SPECIES_TABLE, InfoRetriever::getSpeciesIds);
    }

    public static void writePokemonSpeciesTransInserts(int start) {
        Function<String, List<String>> func = InfoRetriever::getSpeciesNames;
        writeTransTable(Consts.POKEMONS_SPECIES_TRANS_FILE, Consts.POKEMONS_SPECIES_TRANS_TABLE, func, start);
    }

    public static void writePokemonNaturesInserts() {
        writeIdTable(Consts.POKEMONS_NATURES_FILE, Consts.POKEMONS_NATURES_TABLE, InfoRetriever::getNaturesIds);
    }

    public static void writePokemonNaturesTransInserts() {
        Function<String, List<String>> func = InfoRetriever::getNaturesNames;
        writeTransTable(Consts.POKEMONS_NATURES_TRANS_FILE, Consts.POKEMONS_NATURES_TRANS_TABLE, func);
    }

    public static void writePokemonColorsInserts() {
        writeIdTable(Consts.POKEMONS_COLORS_FILE, Consts.POKEMONS_COLORS_TABLE, InfoRetriever::getColorsIds);
    }

    public static void writePokemonColorsTransInserts() {
        Function<String, List<String>> func = InfoRetriever::getColorsNames;
        writeTransTable(Consts.POKEMONS_COLORS_TRANS_FILE, Consts.POKEMONS_COLORS_TRANS_TABLE, func);
    }

    public static void writePokemonShapesInserts() {
        writeIdTable(Consts.POKEMONS_SHAPES_FILE, Consts.POKEMONS_SHAPES_TABLE, InfoRetriever::getShapesIds);
    }

    public static void writePokemonShapesTransInserts() {
        Function<String, List<String>> func = InfoRetriever::getShapesNames;
        writeTransTable(Consts.POKEMONS_SHAPES_TRANS_FILE, Consts.POKEMONS_SHAPES_TRANS_TABLE, func);
    }

    public static void writePokemonHabitatsInserts() {
        writeIdTable(Consts.POKEMONS_HABITATS_FILE, Consts.POKEMONS_HABITATS_TABLE, InfoRetriever::getHabitatsIds);
    }

    public static void writePokemonHabitatsTransInserts() {
        Function<String, List<String>> func = InfoRetriever::getHabitatsNames;
        writeTransTable(Consts.POKEMONS_HABITATS_TRANS_FILE, Consts.POKEMONS_HABITATS_TRANS_TABLE, func);
    }

    public static void writePokemons(int lower, int upper) {
        List<PokemonSpecies> pokemons = InfoRetriever.getPokemons(lower, upper);
        SQLWriter.writePokemonTable(Consts.POKEMONS_FILE, Consts.POKEMONS_TABLE, pokemons, lower);

        List<Integer> ids = new ArrayList<>();
        pokemons.forEach(p -> ids.add(p.getId()));
        SQLWriter.writeIdTable(Consts.POKEMONS_DESC_FILE, Consts.POKEMONS_DESC_TABLE, ids);

        Function<String, List<String>> descriptions = lang -> {
            List<String> results = new ArrayList<>();

            for (PokemonSpecies pokemon : pokemons) {
                Optional<PokemonSpeciesFlavorText> d = pokemon.getFlavorTextEntries().stream()
                                                              .filter(n -> n.getLanguage().getName().equals(lang))
                                                              .findFirst();
                if (d.isPresent()) {
                    results.add(d.get().getFlavorText());
                }
            }

            return results;
        };

        writeTransTable(Consts.POKEMONS_DESC_TRANS_FILE, Consts.POKEMONS_DESC_TRANS_TABLE, descriptions, lower);
    }

    private static void writeIdTable(String filePath, String table, Supplier<List<Integer>> func) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<Integer> ids = func.get();
        SQLWriter.writeIdTable(filePath, table, ids);
    }

    private static void writeTranslateEn(String filePath, String table, Supplier<List<String>> func) {
        try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String lang = "en";
        int langId = InfoRetriever.getLanguageId("en");
        List<String> items = func.get();
        SQLWriter.writeTranslateTable(filePath, table, lang, langId, items, 1);
    }

    private static void writeTransTable(String filePath, String table, Function<String, List<String>> func) {
        writeTransTable(filePath, table, func, 1);
    }

    private static void writeTransTable(String filePath, String table, Function<String, List<String>> func, int start) {
        /*try {
            Files.deleteIfExists(Paths.get(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }*/

        languagesToDo.forEach(lang -> {
            int langId = InfoRetriever.getLanguageId(lang);
            List<String> items = func.apply(lang);
            SQLWriter.writeTranslateTable(filePath, table, lang, langId, items, start);
        });
    }

}
