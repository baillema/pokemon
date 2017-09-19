package database.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "pokemons", schema = "public", catalog = "pokemondb")
public class PokemonsEntity {
    private int id;
    private Integer speciesId;
    private Integer habitatId;
    private Integer colorId;
    private Integer shapeId;
    private Integer descriptionId;
    private PokemonsSpeciesEntity pokemonsSpeciesBySpeciesId;
    private PokemonsHabitatsEntity pokemonsHabitatsByHabitatId;
    private PokemonsColorsEntity pokemonsColorsByColorId;
    private PokemonsShapesEntity pokemonsShapesByShapeId;
    private PokemonsDescriptionsEntity pokemonsDescriptionsByDescriptionId;
    private Collection<PokemonsAcceptedGendersEntity> pokemonsAcceptedGendersById;
    private Collection<PokemonsArticlesEntity> pokemonsArticlesById;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsEntity that = (PokemonsEntity) o;

        if (id != that.id) return false;
        if (speciesId != null ? !speciesId.equals(that.speciesId) : that.speciesId != null) return false;
        if (habitatId != null ? !habitatId.equals(that.habitatId) : that.habitatId != null) return false;
        if (colorId != null ? !colorId.equals(that.colorId) : that.colorId != null) return false;
        if (shapeId != null ? !shapeId.equals(that.shapeId) : that.shapeId != null) return false;
        if (descriptionId != null ? !descriptionId.equals(that.descriptionId) : that.descriptionId != null)
            return false;

        return true;
    }

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

    @ManyToOne
    @JoinColumn(name = "species_id", referencedColumnName = "id")
    public PokemonsSpeciesEntity getPokemonsSpeciesBySpeciesId() {
        return pokemonsSpeciesBySpeciesId;
    }

    public void setPokemonsSpeciesBySpeciesId(PokemonsSpeciesEntity pokemonsSpeciesBySpeciesId) {
        this.pokemonsSpeciesBySpeciesId = pokemonsSpeciesBySpeciesId;
    }

    @ManyToOne
    @JoinColumn(name = "habitat_id", referencedColumnName = "id")
    public PokemonsHabitatsEntity getPokemonsHabitatsByHabitatId() {
        return pokemonsHabitatsByHabitatId;
    }

    public void setPokemonsHabitatsByHabitatId(PokemonsHabitatsEntity pokemonsHabitatsByHabitatId) {
        this.pokemonsHabitatsByHabitatId = pokemonsHabitatsByHabitatId;
    }

    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id")
    public PokemonsColorsEntity getPokemonsColorsByColorId() {
        return pokemonsColorsByColorId;
    }

    public void setPokemonsColorsByColorId(PokemonsColorsEntity pokemonsColorsByColorId) {
        this.pokemonsColorsByColorId = pokemonsColorsByColorId;
    }

    @ManyToOne
    @JoinColumn(name = "shape_id", referencedColumnName = "id")
    public PokemonsShapesEntity getPokemonsShapesByShapeId() {
        return pokemonsShapesByShapeId;
    }

    public void setPokemonsShapesByShapeId(PokemonsShapesEntity pokemonsShapesByShapeId) {
        this.pokemonsShapesByShapeId = pokemonsShapesByShapeId;
    }

    @ManyToOne
    @JoinColumn(name = "description_id", referencedColumnName = "id")
    public PokemonsDescriptionsEntity getPokemonsDescriptionsByDescriptionId() {
        return pokemonsDescriptionsByDescriptionId;
    }

    public void setPokemonsDescriptionsByDescriptionId(PokemonsDescriptionsEntity pokemonsDescriptionsByDescriptionId) {
        this.pokemonsDescriptionsByDescriptionId = pokemonsDescriptionsByDescriptionId;
    }

    @OneToMany(mappedBy = "pokemonsByPokemonId")
    public Collection<PokemonsAcceptedGendersEntity> getPokemonsAcceptedGendersById() {
        return pokemonsAcceptedGendersById;
    }

    public void setPokemonsAcceptedGendersById(Collection<PokemonsAcceptedGendersEntity> pokemonsAcceptedGendersById) {
        this.pokemonsAcceptedGendersById = pokemonsAcceptedGendersById;
    }

    @OneToMany(mappedBy = "pokemonsByPokemonId")
    public Collection<PokemonsArticlesEntity> getPokemonsArticlesById() {
        return pokemonsArticlesById;
    }

    public void setPokemonsArticlesById(Collection<PokemonsArticlesEntity> pokemonsArticlesById) {
        this.pokemonsArticlesById = pokemonsArticlesById;
    }
}
