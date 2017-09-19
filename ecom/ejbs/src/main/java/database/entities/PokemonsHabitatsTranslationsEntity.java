package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_habitats_translations", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsHabitatsTranslationsEntityPK.class)
public class PokemonsHabitatsTranslationsEntity {
    private int pokemonHabitatId;
    private int languageId;
    private String translation;
    private PokemonsHabitatsEntity pokemonsHabitatsByPokemonHabitatId;
    private LanguagesEntity languagesByLanguageId;

    @Id
    @Column(name = "pokemon_habitat_id", nullable = false)
    public int getPokemonHabitatId() {
        return pokemonHabitatId;
    }

    public void setPokemonHabitatId(int pokemonHabitatId) {
        this.pokemonHabitatId = pokemonHabitatId;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsHabitatsTranslationsEntity that = (PokemonsHabitatsTranslationsEntity) o;

        if (pokemonHabitatId != that.pokemonHabitatId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonHabitatId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_habitat_id", referencedColumnName = "id", nullable = false)
    public PokemonsHabitatsEntity getPokemonsHabitatsByPokemonHabitatId() {
        return pokemonsHabitatsByPokemonHabitatId;
    }

    public void setPokemonsHabitatsByPokemonHabitatId(PokemonsHabitatsEntity pokemonsHabitatsByPokemonHabitatId) {
        this.pokemonsHabitatsByPokemonHabitatId = pokemonsHabitatsByPokemonHabitatId;
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
