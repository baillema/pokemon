package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_descriptions_translations", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsDescriptionsTranslationsEntityPK.class)
public class PokemonsDescriptionsTranslationsEntity {
    private int pokemonDescriptionId;
    private int languageId;
    private String translation;
    private PokemonsDescriptionsEntity pokemonsDescriptionsByPokemonDescriptionId;
    private LanguagesEntity languagesByLanguageId;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsDescriptionsTranslationsEntity that = (PokemonsDescriptionsTranslationsEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "pokemon_description_id", referencedColumnName = "id", nullable = false)
    public PokemonsDescriptionsEntity getPokemonsDescriptionsByPokemonDescriptionId() {
        return pokemonsDescriptionsByPokemonDescriptionId;
    }

    public void setPokemonsDescriptionsByPokemonDescriptionId(PokemonsDescriptionsEntity pokemonsDescriptionsByPokemonDescriptionId) {
        this.pokemonsDescriptionsByPokemonDescriptionId = pokemonsDescriptionsByPokemonDescriptionId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    public LanguagesEntity getLanguagesByLanguageId() {
        return languagesByLanguageId;
    }

    public void setLanguagesByLanguageId(LanguagesEntity languagesByLanguageId) {
        this.languagesByLanguageId = languagesByLanguageId;
    }
}
