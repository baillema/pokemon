package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_colors", schema = "public", catalog = "pokemondb")
public class PokemonsColorsEntity {
    private int id;
    private Collection<PokemonsEntity> pokemonsById;
    private Collection<PokemonsColorsTranslationsEntity> pokemonsColorsTranslationsById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsColorsEntity that = (PokemonsColorsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsColorsByColorId")
    public Collection<PokemonsEntity> getPokemonsById() {
        return pokemonsById;
    }

    public void setPokemonsById(Collection<PokemonsEntity> pokemonsById) {
        this.pokemonsById = pokemonsById;
    }

    @OneToMany(mappedBy = "pokemonsColorsByPokemonColorId")
    public Collection<PokemonsColorsTranslationsEntity> getPokemonsColorsTranslationsById() {
        return pokemonsColorsTranslationsById;
    }

    public void setPokemonsColorsTranslationsById(Collection<PokemonsColorsTranslationsEntity> pokemonsColorsTranslationsById) {
        this.pokemonsColorsTranslationsById = pokemonsColorsTranslationsById;
    }
}
