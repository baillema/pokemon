package database.entities.pokemons.translations;

import database.consts.Requests;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pokemons_descriptions_translations", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_DESC_TRANS_ALL,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t"),
        @NamedQuery(name = Requests.POK_DESC_TRANS_FR,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t " +
                        "WHERE t.languageId = 4"),
        @NamedQuery(name = Requests.POK_DESC_TRANS_EN,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t " +
                        "WHERE t.languageId = 8"),
        @NamedQuery(name = Requests.POK_DESC_TRANS_FROM_ID,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t " +
                        "WHERE t.pokemonDescriptionId = :id"),
        @NamedQuery(name = Requests.POK_DESC_TRANS_FROM_LANG,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t " +
                        "WHERE t.languageId = :id"),
        @NamedQuery(name = Requests.POK_DESC_TRANS_FROM_ID_LANG,
                query = "SELECT t " +
                        "FROM PokemonsDescriptionsTranslationsEntity t " +
                        "WHERE t.pokemonDescriptionId = :id " +
                        "AND t.languageId = :lang")
})
public class PokemonsDescriptionsTranslationsEntity implements Serializable {
    private int pokemonDescriptionId;
    private int languageId;
    private String translation;

    @Id
    @Column(name = "pokemon_description_id", nullable = false)
    public int getPokemonDescriptionId() {
        return pokemonDescriptionId;
    }

    public void setPokemonDescriptionId(int pokemonDescriptionId) {
        this.pokemonDescriptionId = pokemonDescriptionId;
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
    @Column(name = "translation", nullable = false, length = -1)
    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    @Override
    public int hashCode() {
        int result = pokemonDescriptionId;
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

        PokemonsDescriptionsTranslationsEntity entity = (PokemonsDescriptionsTranslationsEntity) o;

        if (pokemonDescriptionId != entity.pokemonDescriptionId) {
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
