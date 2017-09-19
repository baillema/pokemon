package database.entities;

import javax.persistence.*;

@Entity
@Table(name = "pokemons_accepted_genders", schema = "public", catalog = "pokemondb")
@IdClass(PokemonsAcceptedGendersEntityPK.class)
public class PokemonsAcceptedGendersEntity {
    private int pokemonId;
    private int pokemonGenderId;
    private PokemonsEntity pokemonsByPokemonId;
    private PokemonsGendersEntity pokemonsGendersByPokemonGenderId;

    @Id
    @Column(name = "pokemon_id", nullable = false)
    public int getPokemonId() {
        return pokemonId;
    }

    public void setPokemonId(int pokemonId) {
        this.pokemonId = pokemonId;
    }

    @Id
    @Column(name = "pokemon_gender_id", nullable = false)
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

        PokemonsAcceptedGendersEntity that = (PokemonsAcceptedGendersEntity) o;

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

    @ManyToOne
    @JoinColumn(name = "pokemon_id", referencedColumnName = "id", nullable = false)
    public PokemonsEntity getPokemonsByPokemonId() {
        return pokemonsByPokemonId;
    }

    public void setPokemonsByPokemonId(PokemonsEntity pokemonsByPokemonId) {
        this.pokemonsByPokemonId = pokemonsByPokemonId;
    }

    @ManyToOne
    @JoinColumn(name = "pokemon_gender_id", referencedColumnName = "id", nullable = false)
    public PokemonsGendersEntity getPokemonsGendersByPokemonGenderId() {
        return pokemonsGendersByPokemonGenderId;
    }

    public void setPokemonsGendersByPokemonGenderId(PokemonsGendersEntity pokemonsGendersByPokemonGenderId) {
        this.pokemonsGendersByPokemonGenderId = pokemonsGendersByPokemonGenderId;
    }
}
