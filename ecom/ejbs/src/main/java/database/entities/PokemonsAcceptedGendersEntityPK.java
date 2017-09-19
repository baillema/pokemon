package database.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class PokemonsAcceptedGendersEntityPK implements Serializable {
    private int pokemonId;
    private int pokemonGenderId;

    @Column(name = "pokemon_id", nullable = false)
    @Id
    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Column(name = "pokemon_gender_id", nullable = false)
    @Id
    public int getPokemonGenderId() {
        return pokemonGenderId;
    }

    public void setPokemonGenderId(int pokemonGenderId) {
        this.pokemonGenderId = pokemonGenderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PokemonsAcceptedGendersEntityPK that = (PokemonsAcceptedGendersEntityPK) o;

        if (pokemonId != that.pokemonId) return false;
        if (pokemonGenderId != that.pokemonGenderId) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = pokemonId;
        result = 31 * result + pokemonGenderId;
        return result;
    }
}
