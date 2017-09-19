package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_shapes_translations", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsShapesTranslationsEntityPK.class)
public class PokemonsShapesTranslationsEntity {
    private int pokemonShapeId;
    private int languageId;
    private String translation;
    private PokemonsShapesEntity pokemonsShapesByPokemonShapeId;
    private LanguagesEntity languagesByLanguageId;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsShapesTranslationsEntity that = (PokemonsShapesTranslationsEntity) o;

        if (pokemonShapeId != that.pokemonShapeId) return false;
        if (languageId != that.languageId) return false;
        if (translation != null ? !translation.equals(that.translation) : that.translation != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonShapeId;
        result = 31 * result + languageId;
        result = 31 * result + (translation != null ? translation.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_shape_id", referencedColumnName = "id", nullable = false)
    public PokemonsShapesEntity getPokemonsShapesByPokemonShapeId() {
        return pokemonsShapesByPokemonShapeId;
    }

    public void setPokemonsShapesByPokemonShapeId(PokemonsShapesEntity pokemonsShapesByPokemonShapeId) {
        this.pokemonsShapesByPokemonShapeId = pokemonsShapesByPokemonShapeId;
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
