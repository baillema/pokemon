package API.resources;

import Services.PokemonService;
import database.dao.PokemonArticleDao;
import database.entities.articles.PokemonsArticlesEntity;

import javax.ejb.EJB;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Application;

@Path("cart")
public class PokemonResource extends Application {
    @EJB
    private PokemonArticleDao pokemonArticleDao;

    @Path("add/{id}")
    @PUT
    public void addPokemonFromCart(@PathParam("id") int pokemonArticleId) {
        PokemonsArticlesEntity pokemon = pokemonArticleDao.find(pokemonArticleId);
        if (PokemonService.pokemonIsBuyable(pokemon)) {
            pokemon.setCartId(1);
            pokemonArticleDao.update(pokemon);
        }
    }

    @Path("remove/{id}")
    @PUT
    public void removePokemonFromCart(@PathParam("id") int pokemonArticleId) {
        PokemonsArticlesEntity pokemon = pokemonArticleDao.find(pokemonArticleId);
        pokemon.setCartId(null);
        pokemonArticleDao.update(pokemon);
    }
}
