package Services;

import database.entities.PokemonsArticlesEntity;

public class PokemonService {

    public static boolean pokemonIsBuyable(PokemonsArticlesEntity pokemon) {
        return pokemon.getCartId() == null;
    }
}
