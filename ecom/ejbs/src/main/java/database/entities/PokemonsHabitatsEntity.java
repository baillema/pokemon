package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_habitats", schema = "public", catalog = "pokemondb")
public class PokemonsHabitatsEntity {
    private int id;
    private Collection<PokemonsEntity> pokemonsById;
    private Collection<PokemonsHabitatsTranslationsEntity> pokemonsHabitatsTranslationsById;

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

        PokemonsHabitatsEntity that = (PokemonsHabitatsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsHabitatsByHabitatId")
    public Collection<PokemonsEntity> getPokemonsById() {
        return pokemonsById;
    }

    public void setPokemonsById(Collection<PokemonsEntity> pokemonsById) {
        this.pokemonsById = pokemonsById;
    }

    @OneToMany(mappedBy = "pokemonsHabitatsByPokemonHabitatId")
    public Collection<PokemonsHabitatsTranslationsEntity> getPokemonsHabitatsTranslationsById() {
        return pokemonsHabitatsTranslationsById;
    }

    public void setPokemonsHabitatsTranslationsById(Collection<PokemonsHabitatsTranslationsEntity> pokemonsHabitatsTranslationsById) {
        this.pokemonsHabitatsTranslationsById = pokemonsHabitatsTranslationsById;
    }
}
