package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PokemonsSpeciesTranslationsEntityPK implements Serializable {
    private int pokemonSpecieId;
    private int languageId;
    private String translation;

    @Column(name = "pokemon_specie_id", nullable = false)
    @Id
    public int getPokemonSpecieId() {
        return pokemonSpecieId;
    }

    public void setPokemonSpecieId(int pokemonSpecieId) {
        this.pokemonSpecieId = pokemonSpecieId;
    }

    @Column(name = "language_id", nullable = false)
    @Id
    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    @Column(name = "translation", nullable = false, length = 50)
    @Id
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public int hashCode() {
        int result = pokemonSpecieId;
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

        PokemonsSpeciesTranslationsEntityPK pk = (PokemonsSpeciesTranslationsEntityPK) o;

        if (pokemonSpecieId != pk.pokemonSpecieId) {
            return false;
        }
        if (languageId != pk.languageId) {
            return false;
        }
        if (translation != null ? !translation.equals(pk.translation) : pk.translation != null) {
            return false;
        }

        return true;
    }
}
