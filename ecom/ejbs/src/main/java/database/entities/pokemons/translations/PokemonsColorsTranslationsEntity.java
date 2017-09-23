package database.entities.pokemons.translations;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemons_colors_translations", schema = "public", catalog = "pokemondb")
public class PokemonsColorsTranslationsEntity implements Serializable {
    private int pokemonColorId;
    private int languageId;
    private String translation;

    @Id
    @Column(name = "pokemon_color_id", nullable = false)
    public int getPokemonColorId() {
        return pokemonColorId;
    }

    public void setPokemonColorId(int pokemonColorId) {
        this.pokemonColorId = pokemonColorId;
    }

    @Id
    @Column(name = "language_id", nullable = false)
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Basic
    @Column(name = "translation", nullable = false, length = 50)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public int hashCode() {
        int result = pokemonColorId;
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

        PokemonsColorsTranslationsEntity entity = (PokemonsColorsTranslationsEntity) o;

        if (pokemonColorId != entity.pokemonColorId) {
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
