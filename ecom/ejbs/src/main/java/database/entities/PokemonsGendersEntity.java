package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_genders", schema = "public", catalog = "pokemondb")
public class PokemonsGendersEntity {
    private int id;
    private Collection<PokemonsAcceptedGendersEntity> pokemonsAcceptedGendersById;
    private Collection<PokemonsGendersTranslationsEntity> pokemonsGendersTranslationsById;

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

        PokemonsGendersEntity that = (PokemonsGendersEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsGendersByPokemonGenderId")
    public Collection<PokemonsAcceptedGendersEntity> getPokemonsAcceptedGendersById() {
        return pokemonsAcceptedGendersById;
    }

    public void setPokemonsAcceptedGendersById(Collection<PokemonsAcceptedGendersEntity> pokemonsAcceptedGendersById) {
        this.pokemonsAcceptedGendersById = pokemonsAcceptedGendersById;
    }

    @OneToMany(mappedBy = "pokemonsGendersByGenderId")
    public Collection<PokemonsGendersTranslationsEntity> getPokemonsGendersTranslationsById() {
        return pokemonsGendersTranslationsById;
    }

    public void setPokemonsGendersTranslationsById(Collection<PokemonsGendersTranslationsEntity> pokemonsGendersTranslationsById) {
        this.pokemonsGendersTranslationsById = pokemonsGendersTranslationsById;
    }
}
