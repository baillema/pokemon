import java.lang.String;

public class Main {
    public static void main (String[] args){
        ElasticSearch es = new ElasticSearch("pokelastic");
        //System.out.println(es.matchAll("pokemons"));
        //System.out.println(es.simpleSearch("pokemons", "name", "golbat"));
        //System.out.println(es.simpleSearch("pokemons", "name", "golbat bulbasaur"));
        //System.out.println(es.simpleSearch("pokemons", "types.types.name", "poison"));
        //System.out.println(es.exactSearch("pokemons", "name", "golbat"));
        //System.out.println(es.wildcardSearch("pokemons", "name", "golb*"));
        //System.out.println(es.fuzzySearch("pokemons", "name", "goldat"));
        //System.out.println(es.stopword("je suis un pokemon", "french"));
        //System.out.println(es.lemmatisation("les tableaux", "french"));

        String[] facetName = {"types.type.name"};
        String[] facetValue = {"poison"};

        System.out.println(es.multiSearch("pokemons","name", "golbat", es.SEARCH, facetName, facetValue, 1));
    }
}
