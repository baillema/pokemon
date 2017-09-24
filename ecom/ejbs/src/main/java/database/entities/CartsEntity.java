package database.entities;

import database.enums.CartsStatesEnum;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "carts", schema = "public", catalog = "pokemondb")
public class CartsEntity implements Serializable {
    private int id;
    private int userId;
    private CartsStatesEnum state;
    private Set<PokemonsArticlesEntity> pokemons;

    public CartsEntity() {

    }

    public CartsEntity(int userId) {
        this.userId = userId;
        this.state = CartsStatesEnum.Current;
    }

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "state", nullable = false)
    public String getState() {
        return this.state.name();
    }

    public void setState(String state) {
        this.state = CartsStatesEnum.valueOf(state);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CartsEntity that = (CartsEntity) o;

        if (id != that.id) return false;
        if (userId != that.userId) return false;
        if (state != that.state) return false;
        return pokemons.equals(that.pokemons);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + userId;
        result = 31 * result + state.hashCode();
        result = 31 * result + pokemons.hashCode();
        return result;
    }

    @OneToMany(
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            fetch = FetchType.EAGER)
    @JoinColumn(name = "cart_id", referencedColumnName = "id")
    public Set<PokemonsArticlesEntity> getPokemons() {
        return pokemons;
    }

    public void setPokemons(Set<PokemonsArticlesEntity> pokemons) {
        this.pokemons = pokemons;
    }
}
