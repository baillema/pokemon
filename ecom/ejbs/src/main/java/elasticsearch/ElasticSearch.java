package elasticsearch;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

import org.elasticsearch.action.admin.indices.analyze.AnalyzeRequest;
import org.elasticsearch.action.admin.indices.analyze.AnalyzeResponse;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.suggest.SuggestBuilder;
import org.elasticsearch.search.suggest.SuggestBuilders;
import org.elasticsearch.search.suggest.completion.CompletionSuggestionBuilder;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;

class ElasticSearch {

    //Generic param to know the type of search
    private static final int SEARCH = 1;
    private static final int FUZZY = 2;
    private static final int WILDCARD = 3;
    private static final int EXACT = 4;

    //Max number of element displayed
    private int size = 10;

    private TransportClient client;

    ElasticSearch(String index)
    {
        Settings settings = Settings.builder()
                .put("cluster.name", index)
                .build();
        client = new PreBuiltXPackTransportClient(settings);
        try {
            client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("152.77.78.29"), 9300));
        } catch (UnknownHostException e) {e.printStackTrace();}
    }

    /*
     * Functions with different types of search
     */

    /**
     * Function to get all elements in the indices index
     * @param indices is the index where we search
     * @return response of the search request in json
     */
    String matchAll(String indices)
    {
        SearchResponse response = client.prepareSearch(indices)
                .setQuery(QueryBuilders.matchAllQuery())
                .setSize(size)
                .get();
        return response.toString();
    }

    /**
     * Function to get elements in the repository index with a search query
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json
     */
    String simpleSearch(String indices, String name, String wordsearched)
    {
        SearchResponse response = client.prepareSearch(indices)
                .setQuery(QueryBuilders.matchQuery(name, wordsearched))
                .setSize(size)
                .get();

        return response.toString();
    }

    /**
     * Function to get elements in the repository index with a search query
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json
     */
    String multiSearch(String indices, String name, String wordsearched, int typeRequest, String facetName[], String facetValue[], int nbFacets)
    {
        SearchRequestBuilder builder = client.prepareSearch(indices).setSize(size);
        BoolQueryBuilder query;

        switch (typeRequest) {
            case SEARCH:
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(name, wordsearched));
                break;
            case FUZZY:
                query = QueryBuilders.boolQuery().must(QueryBuilders.fuzzyQuery(name, wordsearched));
                break;
            case WILDCARD:
                query = QueryBuilders.boolQuery().must(QueryBuilders.wildcardQuery(name, wordsearched));
                break;
            case EXACT:
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchPhraseQuery(name, wordsearched));
                break;
            default:
                query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(name, wordsearched));
                break;
        }

        /*
		 * This function is complex, to understand properly, we need to represent the final query :
		 *
		 * query :
		 * 		bool :
		 * 			must :
		 * 				match : wordsearched
		 * 				bool :
		 * 					should :
		 * 						match : value1 of facet1
		 * 						match : value2 of facet1
		 *				bool :
		 *					should :
		 *						match : value1 of facet2
		 * 						match : value2 of facet2
		 * 				...
		 */

        for(int i=0; i<nbFacets; i++)
        {
            String[] res = facetValue[i].split(",");

            BoolQueryBuilder shouldQuery = QueryBuilders.boolQuery();
            for(int j=0; j<res.length; j++)
            {
                if(res[j].contains("void")) shouldQuery.should(QueryBuilders.matchQuery(facetName[i], ""));
                else shouldQuery.should(QueryBuilders.matchQuery(facetName[i], res[j]));
            }
            query.must(shouldQuery);
        }

        SearchResponse response = builder.setQuery(query).get();

        return response.toString();
    }

    /**
     * Function to get elements in the repository index with an exact match query
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json
     */
    String exactSearch(String indices, String name, String wordsearched)
    {
        SearchResponse response = client.prepareSearch(indices)
                .setQuery(QueryBuilders.matchPhraseQuery(name, wordsearched))
                .setSize(size)
                .get();
        return response.toString();
    }

    /**
     * Function to get elements in the repository index with a wildcard query
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json
     */
    String wildcardSearch(String indices, String name, String wordsearched)
    {
        SearchResponse response = client.prepareSearch(indices)
                .setQuery(QueryBuilders.wildcardQuery(name, wordsearched))
                .setSize(size)
                .get();
        return response.toString();
    }

    /**
     * Function to get elements in the repository index with a fuzzy query
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json (parse with ParsingSearch class)
     */
    String fuzzySearch(String indices, String name, String wordsearched)
    {
        SearchResponse response = client.prepareSearch(indices)
                .setQuery(QueryBuilders.fuzzyQuery(name, wordsearched))
                .setSize(size)
                .get();
        return response.toString();
    }

    /**
     * Function to get elements in the repository index with an autocomplete search
     * /!\ need to create a suggestion index (like a dictionary)
     * @param indices is the index where we search
     * @param name is the attribute/field name
     * @param wordsearched is the word/phrase searched
     * @return response of the search request in json
     */
    String autocomplete(String indices, String name, String wordsearched)
    {
        CompletionSuggestionBuilder csb = SuggestBuilders.completionSuggestion(name).prefix(wordsearched);

        SearchResponse reponse = client.prepareSearch(indices)
                .setSize(100)
                .suggest(new SuggestBuilder().addSuggestion(wordsearched, csb))
                .get();
        return reponse.toString();
    }

    /*
     * Functions to do pretreatment
     */

    /**
     * Function to delete stopword in a specific request
     * /!\ need to index a stopword map : curl -XPUT 'HOST_IP:PORT/stopwords' -H 'Content-Type: application/json' -d '{"settings":{"analysis":{"analyzer":{"french_stopwords":{"type":"standard","stopwords":"_french_"},"english_stopwords":{"type":"standard","stopwords":"_english_"}}}}}'
     * @param wordsearched is a word or a phrase
     * @param language is the language of the stopword (french, english only actually)
     * @return wordsearched without stopword
     */
    String stopword(String wordsearched, String language)
    {
        String response = "";

        AnalyzeRequest req = (new AnalyzeRequest("stopwords")).analyzer(language+"_stopwords").text(wordsearched);
        List<AnalyzeResponse.AnalyzeToken> tokens = client.admin().indices().analyze(req).actionGet().getTokens();
        for (AnalyzeResponse.AnalyzeToken token : tokens) response = response.concat(token.getTerm() + " ");

        return response;
    }

    /**
     * Function to get the root form of a specific request
     * /!\ need to index a lemmatisation map : curl -XPUT 'HOST_IP:PORT/lemmatisation' -H 'Content-Type: application/json' -d '{"settings":{"analysis:{"filter":{"english_stemmer":{"type":"stemmer","language":"english" },"french_stemmer":{"type":"stemmer","language":"french"}},"analyzer":{"english_lemma":{"tokenizer":"standard","filter":["english_stemmer"]},"french_lemma":{"tokenizer":"standard","filter":["french_stemmer"]}}}}}'
     * @param wordsearched is the word/phrase searched
     * @return wordsearched root form
     */
    String lemmatisation(String wordsearched, String language)
    {
        String response = "";

        AnalyzeRequest req = (new AnalyzeRequest("lemmatisation")).analyzer(language+"_lemma").text(wordsearched);
        List<AnalyzeResponse.AnalyzeToken> tokens = client.admin().indices().analyze(req).actionGet().getTokens();
        for (AnalyzeResponse.AnalyzeToken token : tokens) response = response.concat(token.getTerm() + " ");

        return response;
    }
}