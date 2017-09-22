package database.entities;

import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.annotate.JsonBackReference;
import org.codehaus.jackson.annotate.JsonManagedReference;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons_colors", schema = "public", catalog = "pokemondb")
public class PokemonsColorsEntity {
    private int id;
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
    public int hashCode() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        PokemonsColorsEntity entity = (PokemonsColorsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }

    @OneToMany(mappedBy = "pokemonsColorsByPokemonColorId", fetch = FetchType.EAGER)
    @JsonBackReference
    public Collection<PokemonsColorsTranslationsEntity> getPokemonsColorsTranslationsById() {
        return pokemonsColorsTranslationsById;
    }

    public void setPokemonsColorsTranslationsById(Collection<PokemonsColorsTranslationsEntity>
                                                          pokemonsColorsTranslationsById) {
        this.pokemonsColorsTranslationsById = pokemonsColorsTranslationsById;
    }
}
