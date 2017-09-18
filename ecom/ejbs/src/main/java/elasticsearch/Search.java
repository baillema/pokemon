package elasticsearch;

import javax.ejb.Stateless;

@Stateless
public class Search {

    ElasticSearch es = new ElasticSearch("pokelastic");

    public String matchAll(String indices){return es.matchAll(indices);}
    public String simpleSearch(String indices, String name, String wordsearched){return es.simpleSearch(indices,name,wordsearched);}
    public String multiSearch(String indices, String name, String wordsearched, int typeRequest, String facetName[], String facetValue[], int nbFacets){return es.multiSearch(indices,name,wordsearched,typeRequest,facetName,facetValue,nbFacets);}
    public String exactSearch(String indices, String name, String wordsearched){return es.exactSearch(indices,name,wordsearched);}
    public String wildcardSearch(String indices, String name, String wordsearched){return es.wildcardSearch(indices,name,wordsearched);}
    public String fuzzySearch(String indices, String name, String wordsearched){return es.fuzzySearch(indices,name,wordsearched);}
    public String autocomplete(String indices, String name, String wordsearched){return es.autocomplete(indices,name,wordsearched);}

}
