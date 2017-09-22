package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons", schema = "public", catalog = "pokemondb")
public class PokemonsEntity {
    private int id;
    private Integer speciesId;
    private Integer habitatId;
    private Integer colorId;
    private Integer shapeId;
    private Integer descriptionId;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*@Basic
    @Column(name = "species_id", nullable = true)
    public Integer getSpeciesId() {
        return speciesId;
    }

    public void setSpeciesId(Integer speciesId) {
        this.speciesId = speciesId;
    }

    @Basic
    @Column(name = "habitat_id", nullable = true)
    public Integer getHabitatId() {
        return habitatId;
    }

    public void setHabitatId(Integer habitatId) {
        this.habitatId = habitatId;
    }

    @Basic
    @Column(name = "color_id", nullable = true)
    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    @Basic
    @Column(name = "shape_id", nullable = true)
    public Integer getShapeId() {
        return shapeId;
    }

    public void setShapeId(Integer shapeId) {
        this.shapeId = shapeId;
    }

    @Basic
    @Column(name = "description_id", nullable = true)
    public Integer getDescriptionId() {
        return descriptionId;
    }

    public void setDescriptionId(Integer descriptionId) {
        this.descriptionId = descriptionId;
    }
*/
    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (speciesId != null ? speciesId.hashCode() : 0);
        result = 31 * result + (habitatId != null ? habitatId.hashCode() : 0);
        result = 31 * result + (colorId != null ? colorId.hashCode() : 0);
        result = 31 * result + (shapeId != null ? shapeId.hashCode() : 0);
        result = 31 * result + (descriptionId != null ? descriptionId.hashCode() : 0);
        return result;
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
        if (speciesId != null ? !speciesId.equals(entity.speciesId) : entity.speciesId != null) {
            return false;
        }
        if (habitatId != null ? !habitatId.equals(entity.habitatId) : entity.habitatId != null) {
            return false;
        }
        if (colorId != null ? !colorId.equals(entity.colorId) : entity.colorId != null) {
            return false;
        }
        if (shapeId != null ? !shapeId.equals(entity.shapeId) : entity.shapeId != null) {
            return false;
        }
        if (descriptionId != null ? !descriptionId.equals(entity.descriptionId) : entity.descriptionId != null) {
            return false;
        }

        return true;
    }
}
