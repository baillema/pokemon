import me.sargunvohra.lib.pokekotlin.model.PokemonSpecies;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

public class SQLWriter {

    public static void writeEnumTableInserts(String file, String table, List<String> values) {
        Path path = Paths.get(file);

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            int id = 0;
            StringBuilder builder = new StringBuilder();
            builder.append(header(table));
            for (String value : values) {
                builder.append(insert(table, Arrays.asList(id, value)));
                id += 1;
            }
            writer.write(builder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeTranslateTable(String file, String table, String lang, int langId, List<String> values, int start) {
        Path path = Paths.get(file);
        StringBuilder builder = new StringBuilder();
        int id = start;
        builder.append(headerTranslate(table, lang));
        for (String value : values) {
            builder.append(insert(table, Arrays.asList(id, langId, value)));
            id += 1;
        }

        writeToFile(path, builder);
    }

    public static void writeCorrespondanceTable(String file, String table, int id, List<Integer> values) {
        Path path = Paths.get(file);

        StringBuilder builder = new StringBuilder();
        builder.append(header(table));
        for (Integer v : values) {
            builder.append(insert(table, Arrays.asList(v, id)));
        }

        writeToFile(path, builder);
    }

    public static void writeIdTable(String file, String table, List<Integer> ids) {
        Path path = Paths.get(file);

        StringBuilder builder = new StringBuilder();
        builder.append(header(table));
        for (Integer id : ids) {
            builder.append(insert(table, Arrays.asList(id)));
        }

        writeToFile(path, builder);
    }

    public static void writePokemonTable(String file, String table, List<PokemonSpecies> pokemons, int start) {
        Path path = Paths.get(file);

        StringBuilder builder = new StringBuilder();
        builder.append(header(table));
        // FIXME description id
        int descId = start;
        for (PokemonSpecies pokemon : pokemons) {
            int id = pokemon.getId();
            int speciesId = pokemon.getId();

            int habitatId = -1;
            if (pokemon.getHabitat() != null) {
                habitatId = pokemon.getHabitat().getId();
            }

            int colorId = -1;
            if (pokemon.getColor() != null) {
                colorId = pokemon.getColor().getId();
            }

            int shapeId = -1;
            if (pokemon.getShape() != null) {
                shapeId = pokemon.getShape().getId();
            }

            List<Object> objects = Arrays.asList(
                    id,
                    speciesId,
                    habitatId == -1 ? "NULL" : habitatId,
                    colorId == -1 ? "NULL" : colorId,
                    shapeId == -1 ? "NULL" : shapeId,
                    descId);

            builder.append(insert(table, objects));
            descId += 1;
        }

        writeToFile(path, builder);
    }

    private static void createIfNotExists(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String header(String tableName) {
        return "-- Values for the " + tableName + " table.\n";
    }

    private static String headerTranslate(String tableName, String lang) {
        return "-- Values for the " + tableName + " table (language: " + lang + ").\n";
    }

    private static String insert(String table, List<Object> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach(v -> {
            if (v instanceof Integer || v instanceof Long || v instanceof Double) {
                builder.append(v + ", ");
            } else if (v instanceof String) {
                v = ((String) v).replace("'", "''");
                builder.append(String.format("'%s', ", v));
            }
        });
        builder.delete(builder.length() - 2, builder.length());
        return String.format("INSERT INTO %s VALUES (%s);\n", table, builder.toString());
    }

    private static void writeToFile(Path path, StringBuilder builder) {
        try {
            createIfNotExists(path);
            Files.write(path, builder.toString().getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
