package database.entities.pokemons;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pokemons_descriptions", schema = "public", catalog = "pokemondb")
public class PokemonsDescriptionsEntity {
    private int id;

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

        PokemonsDescriptionsEntity entity = (PokemonsDescriptionsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
