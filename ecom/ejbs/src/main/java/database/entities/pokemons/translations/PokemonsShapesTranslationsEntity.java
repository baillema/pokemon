package database.entities.pokemons.translations;

import database.entities.pokemons.PokemonsShapesEntity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemons_shapes_translations", schema = "public", catalog = "pokemondb")
public class PokemonsShapesTranslationsEntity implements Serializable {
    private int pokemonShapeId;
    private int languageId;
    private String translation;

    @Id
    @Column(name = "pokemon_shape_id", nullable = false)
    public int getPokemonShapeId() {
        return pokemonShapeId;
    }

    public void setPokemonShapeId(int pokemonShapeId) {
        this.pokemonShapeId = pokemonShapeId;
    }

    @Id
    @Column(name = "language_id", nullable = false)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Id
    @Column(name = "translation", nullable = false, length = 50)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public int hashCode() {
        int result = pokemonShapeId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PokemonsShapesTranslationsEntity entity = (PokemonsShapesTranslationsEntity) o;

        if (pokemonShapeId != entity.pokemonShapeId) {
            return false;
        }
        if (languageId != entity.languageId) {
            return false;
        }
        if (translation != null ? !translation.equals(entity.translation) : entity.translation != null) {
            return false;
        }

        return true;
    }
}
