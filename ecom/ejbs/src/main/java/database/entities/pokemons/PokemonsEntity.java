package database.entities.pokemons;

import database.consts.Requests;
import database.entities.pokemons.base.*;

import javax.persistence.*;

@Entity
@Table(name = "pokemons", schema = "public", catalog = "pokemondb")
@NamedQueries({
        @NamedQuery(name = Requests.POK_ALL,
                query = "SELECT x " +
                        "FROM PokemonsEntity x"),
        @NamedQuery(name = Requests.POK_FROM_ID,
                query = "SELECT x " +
                        "FROM PokemonsEntity x " +
                        "WHERE x.id = :id")
})
public class PokemonsEntity {
    private int id;

    private PokemonsColorsEntity color;
    private PokemonsDescriptionsEntity description;
    //private PokemonsGendersEntity genders;
    private PokemonsHabitatsEntity habitat;
    private PokemonsShapesEntity shape;
    private PokemonsSpeciesEntity species;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "color_id")
    public PokemonsColorsEntity getColor() {
        return color;
    }

    public void setColor(PokemonsColorsEntity color) {
        this.color = color;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "description_id")
    public PokemonsDescriptionsEntity getDescription() {
        return description;
    }

    public void setDescription(PokemonsDescriptionsEntity description) {
        this.description = description;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "habitat_id")
    public PokemonsHabitatsEntity getHabitat() {
        return habitat;
    }

    public void setHabitat(PokemonsHabitatsEntity habitat) {
        this.habitat = habitat;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "shape_id")
    public PokemonsShapesEntity getShape() {
        return shape;
    }

    public void setShape(PokemonsShapesEntity shape) {
        this.shape = shape;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "species_id")
    public PokemonsSpeciesEntity getSpecies() {
        return species;
    }

    public void setSpecies(PokemonsSpeciesEntity species) {
        this.species = species;
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

        PokemonsEntity entity = (PokemonsEntity) o;

        if (id != entity.id) {
            return false;
        }

        return true;
    }
}
