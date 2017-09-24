package Services;

import database.entities.articles.PokemonsArticlesEntity;

public class PokemonService {

    public static boolean pokemonIsBuyable(PokemonsArticlesEntity pokemon) {
        return pokemon.getCartId() == null;
    }
}
