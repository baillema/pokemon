package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_descriptions", schema = "public", catalog = "pokemondb")
public class PokemonsDescriptionsEntity {
    private int id;
    private Collection<PokemonsEntity> pokemonsById;
    private Collection<PokemonsDescriptionsTranslationsEntity> pokemonsDescriptionsTranslationsById;

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

        PokemonsDescriptionsEntity that = (PokemonsDescriptionsEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsDescriptionsByDescriptionId")
    public Collection<PokemonsEntity> getPokemonsById() {
        return pokemonsById;
    }

    public void setPokemonsById(Collection<PokemonsEntity> pokemonsById) {
        this.pokemonsById = pokemonsById;
    }

    @OneToMany(mappedBy = "pokemonsDescriptionsByPokemonDescriptionId")
    public Collection<PokemonsDescriptionsTranslationsEntity> getPokemonsDescriptionsTranslationsById() {
        return pokemonsDescriptionsTranslationsById;
    }

    public void setPokemonsDescriptionsTranslationsById(Collection<PokemonsDescriptionsTranslationsEntity> pokemonsDescriptionsTranslationsById) {
        this.pokemonsDescriptionsTranslationsById = pokemonsDescriptionsTranslationsById;
    }
}
