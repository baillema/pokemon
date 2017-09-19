package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class TradesEntityPK implements Serializable {
    private int firstUserId;
    private int firstPokemonId;
    private int secondUserId;
    private int secondPokemonId;

    @Column(name = "first_user_id", nullable = false)
    @Id
    public int getFirstUserId() {
        return firstUserId;
    }

    public void setFirstUserId(int firstUserId) {
        this.firstUserId = firstUserId;
    }

    @Column(name = "first_pokemon_id", nullable = false)
    @Id
    public int getFirstPokemonId() {
        return firstPokemonId;
    }

    public void setFirstPokemonId(int firstPokemonId) {
        this.firstPokemonId = firstPokemonId;
    }

    @Column(name = "second_user_id", nullable = false)
    @Id
    public int getSecondUserId() {
        return secondUserId;
    }

    public void setSecondUserId(int secondUserId) {
        this.secondUserId = secondUserId;
    }

    @Column(name = "second_pokemon_id", nullable = false)
    @Id
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

        TradesEntityPK that = (TradesEntityPK) o;

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
}
