package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_colors_translations", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsColorsTranslationsEntityPK.class)
public class PokemonsColorsTranslationsEntity {
    private int pokemonColorId;
    private int languageId;
    private String translation;
    private PokemonsColorsEntity pokemonsColorsByPokemonColorId;
    private LanguagesEntity languagesByLanguageId;

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

        PokemonsColorsTranslationsEntity that = (PokemonsColorsTranslationsEntity) o;

        if (pokemonColorId != that.pokemonColorId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonColorId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_color_id", referencedColumnName = "id", nullable = false)
    public PokemonsColorsEntity getPokemonsColorsByPokemonColorId() {
        return pokemonsColorsByPokemonColorId;
    }

    public void setPokemonsColorsByPokemonColorId(PokemonsColorsEntity pokemonsColorsByPokemonColorId) {
        this.pokemonsColorsByPokemonColorId = pokemonsColorsByPokemonColorId;
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
