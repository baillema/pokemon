package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_species", schema = "public", catalog = "pokemondb")
public class PokemonsSpeciesEntity {
    private int id;
    private Collection<PokemonsEntity> pokemonsById;
    private Collection<PokemonsSpeciesTranslationsEntity> pokemonsSpeciesTranslationsById;

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

        PokemonsSpeciesEntity that = (PokemonsSpeciesEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsSpeciesBySpeciesId")
    public Collection<PokemonsEntity> getPokemonsById() {
        return pokemonsById;
    }

    public void setPokemonsById(Collection<PokemonsEntity> pokemonsById) {
        this.pokemonsById = pokemonsById;
    }

    @OneToMany(mappedBy = "pokemonsSpeciesByPokemonSpecieId")
    public Collection<PokemonsSpeciesTranslationsEntity> getPokemonsSpeciesTranslationsById() {
        return pokemonsSpeciesTranslationsById;
    }

    public void setPokemonsSpeciesTranslationsById(Collection<PokemonsSpeciesTranslationsEntity> pokemonsSpeciesTranslationsById) {
        this.pokemonsSpeciesTranslationsById = pokemonsSpeciesTranslationsById;
    }
}
