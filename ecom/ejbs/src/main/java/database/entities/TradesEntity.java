package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "trades", schema = "public", catalog = "pokemondb")
@IdClass(TradesEntityPK.class)
public class TradesEntity {
    private int firstUserId;
    private int firstPokemonId;
    private int secondUserId;
    private int secondPokemonId;
    private UsersEntity usersByFirstUserId;
    private PokemonsArticlesEntity pokemonsArticlesByFirstPokemonId;
    private UsersEntity usersBySecondUserId;
    private PokemonsArticlesEntity pokemonsArticlesBySecondPokemonId;

    @Id
    @Column(name = "first_user_id", nullable = false)
    public int getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(int firstUserId) {
        this.firstUserId = firstUserId;
    }

    @Id
    @Column(name = "first_pokemon_id", nullable = false)
    public int getFirstPokemonId() {
        return firstPokemonId;
    }

    public void setFirstPokemonId(int firstPokemonId) {
        this.firstPokemonId = firstPokemonId;
    }

    @Id
    @Column(name = "second_user_id", nullable = false)
    public int getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(int secondUserId) {
        this.secondUserId = secondUserId;
    }

    @Id
    @Column(name = "second_pokemon_id", nullable = false)
    public int getSecondPokemonId() {
        return secondPokemonId;
    }

    public void setSecondPokemonId(int secondPokemonId) {
        this.secondPokemonId = secondPokemonId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TradesEntity that = (TradesEntity) o;

        if (firstUserId != that.firstUserId) return false;
        if (firstPokemonId != that.firstPokemonId) return false;
        if (secondUserId != that.secondUserId) return false;
        if (secondPokemonId != that.secondPokemonId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = firstUserId;
        result = 31 * result + firstPokemonId;
        result = 31 * result + secondUserId;
        result = 31 * result + secondPokemonId;
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "first_user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersByFirstUserId() {
        return usersByFirstUserId;
    }

    public void setUsersByFirstUserId(UsersEntity usersByFirstUserId) {
        this.usersByFirstUserId = usersByFirstUserId;
    }

    @ManyToOne
    @JoinColumn(name = "first_pokemon_id", referencedColumnName = "id", nullable = false)
    public PokemonsArticlesEntity getPokemonsArticlesByFirstPokemonId() {
        return pokemonsArticlesByFirstPokemonId;
    }

    public void setPokemonsArticlesByFirstPokemonId(PokemonsArticlesEntity pokemonsArticlesByFirstPokemonId) {
        this.pokemonsArticlesByFirstPokemonId = pokemonsArticlesByFirstPokemonId;
    }

    @ManyToOne
    @JoinColumn(name = "second_user_id", referencedColumnName = "id", nullable = false)
    public UsersEntity getUsersBySecondUserId() {
        return usersBySecondUserId;
    }

    public void setUsersBySecondUserId(UsersEntity usersBySecondUserId) {
        this.usersBySecondUserId = usersBySecondUserId;
    }

    @ManyToOne
    @JoinColumn(name = "second_pokemon_id", referencedColumnName = "id", nullable = false)
    public PokemonsArticlesEntity getPokemonsArticlesBySecondPokemonId() {
        return pokemonsArticlesBySecondPokemonId;
    }

    public void setPokemonsArticlesBySecondPokemonId(PokemonsArticlesEntity pokemonsArticlesBySecondPokemonId) {
        this.pokemonsArticlesBySecondPokemonId = pokemonsArticlesBySecondPokemonId;
    }
}
