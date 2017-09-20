package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_species_translations", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsSpeciesTranslationsEntityPK.class)
public class PokemonsSpeciesTranslationsEntity {
    private int pokemonSpecieId;
    private int languageId;
    private String translation;
    /*private PokemonsSpeciesEntity pokemonsSpeciesByPokemonSpecieId;
    private LanguagesEntity languagesByLanguageId;
*/
    @Id
    @Column(name = "pokemon_specie_id", nullable = false)
    public int getPokemonSpecieId() {
        return pokemonSpecieId;
    }

    public void setPokemonSpecieId(int pokemonSpecieId) {
        this.pokemonSpecieId = pokemonSpecieId;
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

        PokemonsSpeciesTranslationsEntity entity = (PokemonsSpeciesTranslationsEntity) o;

        if (pokemonSpecieId != entity.pokemonSpecieId) {
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

/*    @ManyToOne
    @JoinColumn(name = "pokemon_specie_id", referencedColumnName = "id", nullable = false)
    public PokemonsSpeciesEntity getPokemonsSpeciesByPokemonSpecieId() {
        return pokemonsSpeciesByPokemonSpecieId;
    }

    public void setPokemonsSpeciesByPokemonSpecieId(PokemonsSpeciesEntity pokemonsSpeciesByPokemonSpecieId) {
        this.pokemonsSpeciesByPokemonSpecieId = pokemonsSpeciesByPokemonSpecieId;
    }

    @ManyToOne
    @JoinColumn(name = "language_id", referencedColumnName = "id", nullable = false)
    public LanguagesEntity getLanguagesByLanguageId() {
        return languagesByLanguageId;
    }

    public void setLanguagesByLanguageId(LanguagesEntity languagesByLanguageId) {
        this.languagesByLanguageId = languagesByLanguageId;
    }*/
}
