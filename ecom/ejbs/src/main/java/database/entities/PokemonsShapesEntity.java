package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_shapes", schema = "public", catalog = "pokemondb")
public class PokemonsShapesEntity {
    private int id;
    private Collection<PokemonsEntity> pokemonsById;
    private Collection<PokemonsShapesTranslationsEntity> pokemonsShapesTranslationsById;

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

        PokemonsShapesEntity that = (PokemonsShapesEntity) o;

        if (id != that.id) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @OneToMany(mappedBy = "pokemonsShapesByShapeId")
    public Collection<PokemonsEntity> getPokemonsById() {
        return pokemonsById;
    }

    public void setPokemonsById(Collection<PokemonsEntity> pokemonsById) {
        this.pokemonsById = pokemonsById;
    }

    @OneToMany(mappedBy = "pokemonsShapesByPokemonShapeId")
    public Collection<PokemonsShapesTranslationsEntity> getPokemonsShapesTranslationsById() {
        return pokemonsShapesTranslationsById;
    }

    public void setPokemonsShapesTranslationsById(Collection<PokemonsShapesTranslationsEntity> pokemonsShapesTranslationsById) {
        this.pokemonsShapesTranslationsById = pokemonsShapesTranslationsById;
    }
}
