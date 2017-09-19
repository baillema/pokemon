package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PokemonsDescriptionsTranslationsEntityPK implements Serializable {
    private int pokemonDescriptionId;
    private int languageId;
    private String translation;

    @Column(name = "pokemon_description_id", nullable = false)
    @Id
    public int getPokemonDescriptionId() {
        return pokemonDescriptionId;
    }

    public void setPokemonDescriptionId(int pokemonDescriptionId) {
        this.pokemonDescriptionId = pokemonDescriptionId;
    }

    @Column(name = "language_id", nullable = false)
    @Id
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Column(name = "translation", nullable = false, length = -1)
    @Id
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsDescriptionsTranslationsEntityPK that = (PokemonsDescriptionsTranslationsEntityPK) o;

        if (pokemonDescriptionId != that.pokemonDescriptionId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonDescriptionId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }
}
