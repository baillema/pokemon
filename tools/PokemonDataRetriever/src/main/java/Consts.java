public class Consts {
    public static String BASE_PATH = "output/";

    public static String FILE_EXTENSION = ".sql";

    public static String LANGUAGE_TABLE = "languages";
    public static String LANGUAGE_FILE = insertFile(LANGUAGE_TABLE);

    public static String POKEMONS_TABLE = "pokemons";
    public static String POKEMONS_FILE = insertFile(POKEMONS_TABLE);

    public static String POKEMONS_DESC_TABLE = "pokemons_descriptions";
    public static String POKEMONS_DESC_FILE = insertFile(POKEMONS_DESC_TABLE);

    public static String POKEMONS_DESC_TRANS_TABLE = "pokemons_descriptions_translations";
    public static String POKEMONS_DESC_TRANS_FILE = insertFile(POKEMONS_DESC_TRANS_TABLE);

    public static String POKEMONS_GENDERS_TABLE = "pokemons_genders";
    public static String POKEMONS_GENDERS_FILE = insertFile(POKEMONS_GENDERS_TABLE);


    public static String POKEMONS_GENDERS_TRANS_TABLE = "pokemons_genders_translations";
    public static String POKEMONS_GENDERS_TRANS_FILE = insertFile(POKEMONS_GENDERS_TRANS_TABLE);

    public static String POKEMONS_ACCEPTED_GENDERS_TABLE = "pokemons_accepted_genders";
    public static String POKEMONS_ACCEPTED_GENDERS_FILE = insertFile(POKEMONS_ACCEPTED_GENDERS_TABLE);

    public static String POKEMONS_SPECIES_TABLE = "pokemons_species";
    public static String POKEMONS_SPECIES_FILE = insertFile(POKEMONS_SPECIES_TABLE);

    public static String POKEMONS_SPECIES_TRANS_TABLE = "pokemons_species_translations";
    public static String POKEMONS_SPECIES_TRANS_FILE = insertFile(POKEMONS_SPECIES_TRANS_TABLE);

    public static String POKEMONS_NATURES_TABLE = "pokemons_natures";
    public static String POKEMONS_NATURES_FILE = insertFile(POKEMONS_NATURES_TABLE);

    public static String POKEMONS_NATURES_TRANS_TABLE = "pokemons_natures_translations";
    public static String POKEMONS_NATURES_TRANS_FILE = insertFile(POKEMONS_NATURES_TRANS_TABLE);

    public static String POKEMONS_COLORS_TABLE = "pokemons_colors";
    public static String POKEMONS_COLORS_FILE = insertFile(POKEMONS_COLORS_TABLE);

    public static String POKEMONS_COLORS_TRANS_TABLE = "pokemons_colors_translations";
    public static String POKEMONS_COLORS_TRANS_FILE = insertFile(POKEMONS_COLORS_TRANS_TABLE);

    public static String POKEMONS_SHAPES_TABLE = "pokemons_shapes";
    public static String POKEMONS_SHAPES_FILE = insertFile(POKEMONS_SHAPES_TABLE);

    public static String POKEMONS_SHAPES_TRANS_TABLE = "pokemons_shapes_translations";
    public static String POKEMONS_SHAPES_TRANS_FILE = insertFile(POKEMONS_SHAPES_TRANS_TABLE);

    public static String POKEMONS_HABITATS_TABLE = "pokemons_habitats";
    public static String POKEMONS_HABITATS_FILE = insertFile(POKEMONS_HABITATS_TABLE);

    public static String POKEMONS_HABITATS_TRANS_TABLE = "pokemons_habitats_translations";
    public static String POKEMONS_HABITATS_TRANS_FILE = insertFile(POKEMONS_HABITATS_TRANS_TABLE);

    public static String ITEMS_TABLE = "items";
    public static String ITEMS_FILE = insertFile(ITEMS_TABLE);

    public static String ITEMS_DESC_TABLE = "items_descriptions";
    public static String ITEMS_DESC_FILE = insertFile(ITEMS_DESC_TABLE);

    public static String ITEMS_DESC_TRANS_TABLE = "items_descriptions_translations";
    public static String ITEMS_DESC_TRANS_FILE = insertFile(ITEMS_DESC_TRANS_TABLE);

    public static String ITEMS_NAMES_TABLE = "items_names";
    public static String ITEMS_NAMES_FILE = insertFile(ITEMS_NAMES_TABLE);

    public static String ITEMS_NAMES_TRANS_TABLE = "items_names_translations";
    public static String ITEMS_NAMES_TRANS_FILE = insertFile(ITEMS_NAMES_TRANS_TABLE);

    public static String ITEMS_CAT_TABLE = "items_categories";
    public static String ITEMS_CAT_FILE = insertFile(ITEMS_CAT_TABLE);

    public static String ITEMS_CAT_TRANS_TABLE = "items_categories_translations";
    public static String ITEMS_CAT_TRANS_FILE = insertFile(ITEMS_CAT_TRANS_TABLE);

    private static String insertFile(String table) {
        return BASE_PATH + "insert_" + table + FILE_EXTENSION;
    }
}
